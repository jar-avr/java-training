package com.training.services;

import com.training.dto.InspectorRegistrationDto;
import com.training.dto.PersonRegistrationDto;
import com.training.dto.UsersWrapper;
import com.training.entity.Person;
import com.training.entity.Role;
import com.training.entity.User;
import com.training.repository.PersonRepository;
import com.training.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        if (!userRepository.findByEmail("email@gmail.com").isPresent()) {
            userRepository.save(User.builder()
                    .firstName("admin")
                    .lastName("adminovich")
                    .password(new BCryptPasswordEncoder().encode("root"))
                    .email("email@gmail.com")
                    .role(Role.ADMIN)
                    .build());
        }
        if (!userRepository.findByEmail("inspector@gmail.com").isPresent()) {
            userRepository.save(User.builder()
                    .firstName("someone")
                    .lastName("anyone")
                    .password(new BCryptPasswordEncoder().encode("root"))
                    .email("inspector@gmail.com")
                    .role(Role.INSPECTOR)
                    .build());
        }
    }

    public User saveNewPerson(PersonRegistrationDto registration) throws Exception {
        checkIfEmailExists(registration.getEmail());

        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(registration.getPassword()));
        user.setRole(Role.PERSON);
        user.setPerson(saveNewPersonUtility(registration, user));
        return userRepository.save(user);
    }

    public Person saveNewPersonUtility(PersonRegistrationDto registration, User user) {
        return personRepository.save(Person.builder()
                .personType(registration.getPersonType())
                .city(registration.getCity())
                .street(registration.getStreet())
                .user(user)
                .build());
    }

    public User saveNewInspector(InspectorRegistrationDto registration) throws Exception {
        checkIfEmailExists(registration.getEmail());

        return userRepository.save(User.builder()
                .firstName(registration.getFirstName())
                .lastName(registration.getLastName())
                .email(registration.getEmail())
                .password(new BCryptPasswordEncoder().encode(registration.getPassword()))
                .role(Role.INSPECTOR)
                .build());
    }

    private void checkIfEmailExists(String email) throws Exception {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception ("There is already an account registered with email " + email);
        }
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User with email " + email + " was not found!"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UsersWrapper findAllNewUsers(int page, int size, String sort_by, String sort_direction) {
        Page<User> retrievedPage = userRepository.findAllByECodeIsNull(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.valueOf(sort_direction), sort_by)));
        return new UsersWrapper(retrievedPage.getContent(), retrievedPage.getNumber() + 1, retrievedPage.getTotalPages());
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User with email " + email + " was not found!"));
    }

    public void updateECodeWherePersonId(long id, long eCode) {
        personRepository.updateECodeWherePersonId(id, eCode);
    }

    @Transactional
    public void savePersonsWithECode(List<User> users) {
        users.stream().filter(user -> user.getPerson().getECode() != null).forEach(this::save);
    }
}
