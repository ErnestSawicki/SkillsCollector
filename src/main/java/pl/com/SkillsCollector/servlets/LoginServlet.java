package pl.com.SkillsCollector.servlets;

import pl.com.SkillsCollector.dao.UserDao;
import pl.com.SkillsCollector.model.User;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao((EntityManagerFactory) getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<User> userByPassword = userDao.getAllByUsernameAndPassword(username, password);
        if (userByPassword.size() == 1){
            req.getSession().invalidate();
            req.getSession(true).setAttribute("user", userByPassword.get(0));
            resp.sendRedirect("/user/skills");
        } else {
            req.setAttribute("loginError", "Login or password is not correct");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
