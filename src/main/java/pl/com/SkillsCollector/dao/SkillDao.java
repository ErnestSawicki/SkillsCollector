package pl.com.SkillsCollector.dao;

import pl.com.SkillsCollector.model.Skill;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SkillDao {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public SkillDao(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public void save(Skill skill){
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
    }

    public Skill get(Long id){
        return em.find(Skill.class, id);
    }

    public void update(Skill skill){
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
    }

    public void delete(Skill skill){
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
    }

}
