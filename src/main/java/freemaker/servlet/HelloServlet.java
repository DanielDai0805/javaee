package freemaker.servlet;

import freemaker.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/22.
 * http://viralpatel.net/blogs/freemarker-servlet-tutorial-example/
 * http://freemarker.org/docs/pgui_misc_servlet.html
 */
@WebServlet(name="helloServlet",urlPatterns = {"/servletFreemarker"})
public class HelloServlet extends HttpServlet {
    private static List<User> userList = new ArrayList<User>();
    static {
        userList.add(new User("Bill", "Gates"));
        userList.add(new User("Steve", "Jobs"));
        userList.add(new User("Larry", "Page"));
        userList.add(new User("Sergey", "Brin"));
        userList.add(new User("Larry", "Ellison"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userList);
        req.getRequestDispatcher("/hello.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
