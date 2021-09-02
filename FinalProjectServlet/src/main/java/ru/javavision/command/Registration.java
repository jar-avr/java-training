package ru.javavision.command;

import ru.javavision.dto.PersonRegistrationDto;
import ru.javavision.entity.Person;
import ru.javavision.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("POST")) {
            UserService userService = UserService.getInstance(request.getServletContext());
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String city = request.getParameter("city");
            String street = request.getParameter("street");
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String matchingPass = request.getParameter("matchingPassword");
            String personType = request.getParameter("gridRadios");
            try {
                userService.saveNewPerson(new PersonRegistrationDto(firstName, lastName, personType, city, street, email, pass, matchingPass));
            } catch (Exception e) {
                request.setAttribute("duplicateEmail", true);
                return "/WEB-INF/view/registration-form.jsp";
            }

            request.setAttribute("success", true);
        }

//        if (request.getMethod().equals("GET")) {
//            Person person = new Person();
//            request.setAttribute("person", person);
//        } else if () {
//            Person person = (Person) request.getAttribute("person");
//        }
        return "/WEB-INF/view/registration-form.jsp";
    }
}
