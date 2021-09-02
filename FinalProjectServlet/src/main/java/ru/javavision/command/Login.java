package ru.javavision.command;

import ru.javavision.dao.UserDAO;
import ru.javavision.entity.User;
import ru.javavision.service.UserService;
import ru.javavision.util.Crypt;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = UserService.getInstance(request.getServletContext());
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        if (email == null || email.equals("") || pass == null || pass.equals("")) {
            if (request.getMethod().equals("POST")) {
                request.setAttribute("error_empty", true);
            }
            return "/WEB-INF/view/login.jsp";
        }

        boolean passwordMatches;
        User user;
        try {
            user = userService.findByEmail(email);
            passwordMatches = Crypt.verifyUserPassword(pass, user.getPassword());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "/WEB-INF/view/login.jsp";
        }

        if (!passwordMatches) {
            request.setAttribute("error_password", true);
            return "/WEB-INF/view/login.jsp";
        }

        request.getSession().setAttribute("user", user);

        switch (user.getRole().getAuthority()) {
            case "ROLE_PERSON": return "redirect:/person/main";
            case "ROLE_INSPECTOR": return "redirect:/inspector/main";
            case "ROLE_ADMIN": return "redirect:/admin/main";
        }

        return "/WEB-INF/view/login.jsp";
    }
}
