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
import java.util.List;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/user/unknown-sources")
public class UserUnknownSourcesServlet extends HttpServlet {

    private SourceDao sourceDao;
    @Override
    public void init() throws ServletException {
        sourceDao = new SourceDao((EntityManagerFactory)getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<Source> sourcesUnknown = sourceDao.sourceUnknownToUser(user);
        System.out.println(sourcesUnknown);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        req.setAttribute("sourcesUnknown", sourcesUnknown);
        req.getRequestDispatcher("/WEB-INF/views/user-unknown-sources.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
