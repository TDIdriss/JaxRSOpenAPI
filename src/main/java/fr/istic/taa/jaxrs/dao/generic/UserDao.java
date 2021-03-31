package fr.istic.taa.jaxrs.dao.generic;

import jpa.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao {

    private EntityManager manager;

    public UserDao(EntityManager manager) {
        this.manager = manager;
    }

    public void createUser(User user ){
        manager.persist(user);
    }

    public void listUser(){
       // List<User> resultList = manager.createQuery("Select a From User a", User.class).getResultList();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
// assuming a is an Integer
// if returning multiple fields, look into using a Tuple
//    or specifying the return type as an Object or Object[]
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from.get("a"));
                //.where(from.get("a").in(1, 2, 3, 4));



        System.out.println("num of User:" + resultList.size());
        for (User next : resultList) {
            System.out.println("next User: " + next);
        }
    }

    public User chooseUser(Long id){

        return manager.createQuery("Select a From User a Where a.id = :id ", User.class).setParameter("id",id).getSingleResult();
    }
}