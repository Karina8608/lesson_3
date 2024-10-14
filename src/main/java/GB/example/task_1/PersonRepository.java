package GB.example.task_1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPU");

    public void addPerson(Person person) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public Person getPerson(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public void updatePerson(Person person) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePerson(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Person> getAllPersons() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Person> people = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        em.close();
        return people;
    }
}

