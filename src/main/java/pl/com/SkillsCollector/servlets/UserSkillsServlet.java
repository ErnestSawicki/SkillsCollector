package pl.com.SkillsCollector.servlets;

import pl.com.SkillsCollector.dao.UserDao;
import pl.com.SkillsCollector.model.Skill;
import pl.com.SkillsCollector.model.User;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {
    UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao = new UserDao((EntityManagerFactory) getServletContext().getAttribute("session_factory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<Skill> userSkills = userDao.userSkills(user);
        Map<String, Integer> skillsMap = new HashMap<>();
        for (int i = 0; i < userSkills.size(); i++) {
            String skillName = userSkills.get(i).getName();
            if (skillsMap.get(skillName) == null){
                skillsMap.put(skillName, 1);
            } else {
                int skillAmount = skillsMap.get(skillName) + 1;
                skillsMap.put(skillName, skillAmount);
            }
        }
        req.setAttribute("skills", skillsMap);
        req.getRequestDispatcher("/WEB-INF/views/user-skills.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
