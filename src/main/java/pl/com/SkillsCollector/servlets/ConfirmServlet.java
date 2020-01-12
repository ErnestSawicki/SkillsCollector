package pl.com.SkillsCollector.servlets;

import pl.com.SkillsCollector.dao.SourceDao;
import pl.com.SkillsCollector.dao.UserDao;
import pl.com.SkillsCollector.model.Source;
import pl.com.SkillsCollector.model.User;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sources/confirm")
public class ConfirmServlet extends HttpServlet {

    private UserDao userDao;
    private SourceDao sourceDao;
    @Override
    public void init() throws ServletException {
        userDao = new UserDao((EntityManagerFactory) getServletContext().getAttribute("session_factory"));
        sourceDao = new SourceDao((EntityManagerFactory)getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long sourceId = Long.parseLong(req.getParameter("sourceId"));
        Source source = sourceDao.get(sourceId);
        System.out.println(source.toString());
        User user = (User)req.getSession().getAttribute("user");
//        user.getSources().add(source);
//        User entity = userDao.get(user.getId());
//        entity.getSources().add(source);
//        userDao.update(entity);
        userDao.addSource(user, source);


        req.getRequestDispatcher("/WEB-INF/views/user-unknown-sources.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
