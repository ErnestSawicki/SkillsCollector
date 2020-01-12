package pl.com.SkillsCollector.dao;

import pl.com.SkillsCollector.model.Source;
import pl.com.SkillsCollector.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SourceDao {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public SourceDao(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public void save(Source source){
        em.getTransaction().begin();
        em.persist(source);
        em.getTransaction().commit();
    }

    public Source get(Long id){
        return em.find(Source.class, id);
    }

    public void update(Source source){
        em.getTransaction().begin();
        em.persist(source);
        em.getTransaction().commit();
    }

    public void delete(Source source){
        em.getTransaction().begin();
        em.remove(source);
        em.getTransaction().commit();
    }

    public List<Source> sourceUnknownToUser(User user){
        List<Source> sourcesInDB = em.createQuery("select DISTINCT s from Source s JOIN FETCH s.skills",Source.class).getResultList();
        List<Source> sourcesKnownToUser = new UserDao(emf).userSources(user);
        sourcesInDB.removeAll(sourcesKnownToUser);
        return sourcesInDB;
    }

}
