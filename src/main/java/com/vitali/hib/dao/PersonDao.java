package com.vitali.hib.dao;

import com.vitali.hib.dto.PersonDto;
import com.vitali.hib.entity.Person;
import com.vitali.hib.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonDao implements Dao<Integer, Person> {
    private static final PersonDao INSTANCE = new PersonDao();
    public static PersonDao getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Person> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root);

        List<Person> resultList = em.createQuery(criteriaQuery).getResultList();
        em.getTransaction().commit();
        em.close();

        return resultList;
    }

    @Override
    public Person findById(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.remove(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Person entity, Integer id) {
        String name = entity.getName();
        String surname = entity.getSurname();

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Person> criteriaUpdate = builder.createCriteriaUpdate(Person.class);
        Root<Person> root = criteriaUpdate.from(Person.class);
        criteriaUpdate.set("name", name);
        criteriaUpdate.set("surname", surname);
        criteriaUpdate.where(builder.equal(root.get("id"), id));
        em.createQuery(criteriaUpdate).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Person save(Person entity) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Person person = Person.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();

        em.persist(person);
        Integer id = person.getId();
        person.setId(id);

        return person;
    }
}
