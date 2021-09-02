package ru.javavision.service;

import ru.javavision.dao.PersonDAO;
import ru.javavision.dao.UserDAO;
import ru.javavision.dto.PersonRegistrationDto;
import ru.javavision.entity.Person;
import ru.javavision.entity.Role;
import ru.javavision.entity.User;
import ru.javavision.util.Crypt;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.sql.SQLException;

public class UserService {
    private static UserDAO userDAO;
    private static PersonDAO personDAO;
    public static UserService instance;

    public static synchronized UserService getInstance(ServletContext servletContext) {
        if (instance == null) {
            String jdbcURL = servletContext.getInitParameter("jdbcURL");
            String jdbcUsername = servletContext.getInitParameter("jdbcUsername");
            String jdbcPassword = servletContext.getInitParameter("jdbcPassword");

            userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
            personDAO = new PersonDAO(jdbcURL, jdbcUsername, jdbcPassword);

                User user = new User();
                user.setFirstName("admin");
                user.setLastName("adminovich");
                try {
                    user.setPassword(Crypt.generateSecurePassword("root"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                user.setEmail("mail@gmail.com");
                user.setRole(Role.ADMIN);
                try {
                    userDAO.save(user);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }


                User user2 = new User();
                user2.setFirstName("someone");
                user2.setLastName("anyone");
                try {
                    user2.setPassword(Crypt.generateSecurePassword("root"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                user2.setEmail("inspector2@gmail.com");
                user2.setRole(Role.INSPECTOR);
                try {
                    userDAO.save(user2);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            instance = new UserService();
        }
        return instance;
    }

    public User saveNewPerson(PersonRegistrationDto registration) throws Exception {
//        try {
//            checkIfEmailExists(registration.getEmail());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(Crypt.generateSecurePassword(registration.getPassword()));
        user.setRole(Role.PERSON);

        userDAO.save(user);
        saveNewPersonUtility(registration, findByEmail(user.getEmail()));
        return user;
    }

    public Person saveNewPersonUtility(PersonRegistrationDto registration, User user) throws Exception {
        Person person = new Person();
        person.setPersonType(registration.getPersonType());
        person.setCity(registration.getCity());
        person.setStreet(registration.getStreet());
        person.setUser(user);
        personDAO.save(person);
        return person;
    }
//
//    public User saveNewInspector(InspectorRegistrationDto registration) throws Exception {
//        checkIfEmailExists(registration.getEmail());
//
//        return userRepository.save(User.builder()
//                .firstName(registration.getFirstName())
//                .lastName(registration.getLastName())
//                .email(registration.getEmail())
//                .password(new BCryptPasswordEncoder().encode(registration.getPassword()))
//                .role(Role.INSPECTOR)
//                .build());
//    }
//
    private void checkIfEmailExists(String email) throws Exception {
        if (userDAO.findByEmail(email).isPresent()) {
            throw new Exception ("There is already an account registered with email " + email);
        }
    }
//
//    @Override
//    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
//        return this.userRepository.findByEmail(email).orElseThrow(() ->
//                new UsernameNotFoundException("User with email " + email + " was not found!"));
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public UsersWrapper findAllNewUsers() {
//        return new UsersWrapper(userRepository.findAllByECodeIsNull());
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }

    public User findByEmail(String email) throws Exception {
        return userDAO.findByEmail(email).orElseThrow(() ->
                new Exception("User with email " + email + " was not found!"));
    }

//    @Transactional
//    public void savePersonsWithECode(List<User> users) {
//        users.forEach(this::save);
//    }
}
