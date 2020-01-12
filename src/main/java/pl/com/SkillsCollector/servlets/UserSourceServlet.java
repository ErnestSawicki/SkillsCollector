package pl.com.SkillsCollector.servlets;

import pl.com.SkillsCollector.dao.UserDao;
import pl.com.SkillsCollector.model.Skill;
import pl.com.SkillsCollector.model.Source;
import pl.com.SkillsCollector.model.User;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/user/sources")
public class UserSourceServlet extends HttpServlet {

    private UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao = new UserDao((EntityManagerFactory)getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<Source> userSources = userDao.userSources(user);
        req.setAttribute("sources", userSources);
        req.getRequestDispatcher("/WEB-INF/views/user-sources.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
