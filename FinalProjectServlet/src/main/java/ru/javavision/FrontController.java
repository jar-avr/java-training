package ru.javavision;

import ru.javavision.command.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {
    private static final String regexPatch = ".*/";
    private final Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("logout", new LogOut());
        commands.put("login", new Login());
        commands.put("registration", new Registration());
        commands.put("access_denied", new AccessDenied());
        commands.put("main", new MainPage());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll( regexPatch, "");
        System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r, re)->"/WEB-INF/view/index.jsp");
        String page = command.execute(request,response);
        if (page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            if (path.equals("main")) {
                System.out.println(page);
            }
            request.getServletContext().getRequestDispatcher(page).forward(request, response);
        }
    }
}