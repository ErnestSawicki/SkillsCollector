package pl.com.SkillsCollector.dao;

import pl.com.SkillsCollector.model.Skill;
import pl.com.SkillsCollector.model.Source;
import pl.com.SkillsCollector.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDao {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public UserDao(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public User get(Long id){
        return em.find(User.class, id);
    }

    public void save(User user){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void update(User user){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void delete(User user){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public Boolean isUsernameAvailable(String name){
        return em.createQuery("SELECT count(u) From User u where u.username =: name", Long.class)
                .setParameter("name", name)
                .getSingleResult() <= 0;
    }

    public List<User> getAll(){
        return em.createQuery("select u FROM User u", User.class).getResultList();
    }

    public List<User> getAllByUsername(String name){
        return em.createQuery("Select u From User u Where u.username =: name", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<User> getAllByUsernameAndPassword(String username, String password){
        return em.createQuery("SELECT u from User u where u.username =: username AND u.password =: password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
    }

    /*Select ss.skill_id
    From users_known_sources us
    Join sources_attached_skills ss
    On ss.source_id = us.source_id
    Where user_id = 1;*/

    public List<Skill> userSkills(User user){
        return em.createQuery("Select sk " +
                "From Source so " +
                "Join so.skills sk " +
                "Join so.users u " +
                "Where u.id =: userId", Skill.class)
                .setParameter("userId", user.getId())
                .getResultList();
    }

    public List<Source> userSources(User user){
        return em.createQuery("Select so " +
                "From Source so " +
                "Join so.users u " +
                "Where u.id =: userId", Source.class)
                .setParameter("userId", user.getId())
                .getResultList();
    }

}
