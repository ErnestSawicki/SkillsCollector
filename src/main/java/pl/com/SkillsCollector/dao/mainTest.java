package pl.com.SkillsCollector.dao;

import pl.com.SkillsCollector.model.Skill;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mainTest {

    public static void main(String[] args) {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.com.SkillsCollector");
        UserDao userDao = new UserDao(emf);

        List<Skill> userSkills = userDao.userSkills(userDao.get(2L));
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
        System.out.println(userSkills);
        System.out.println(skillsMap);*/
    }

}
