package ru.javavision.command;

import ru.javavision.entity.User;
import ru.javavision.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = UserService.getInstance(request.getServletContext());
        switch(((User)request.getSession().getAttribute("user")).getRole().getAuthority()) {

            case "ROLE_PERSON":
                try {
                    User user = userService.findByEmail(((User) request.getSession().getAttribute("user")).getEmail());
                    request.setAttribute("sideMenu", user.getPerson().getECode() != null);
                    request.setAttribute("firstName", user.getFirstName());
                    request.setAttribute("email", user.getEmail());
                    request.setAttribute("eCode", user.getPerson().getECode().getECode());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return "/WEB-INF/view/person/profile.jsp";

            case "ROLE_INSPECTOR":  return "/WEB-INF/view/inspector/inspector_menu.jsp";

            case "ROLE_ADMIN":  return "/WEB-INF/view/admin/admin_menu.jsp";

            default: return "redirect:" + request.getContextPath() + "/login";
        }
    }
}
