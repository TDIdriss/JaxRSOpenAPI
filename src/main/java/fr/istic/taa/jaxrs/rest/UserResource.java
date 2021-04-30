package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.User;

import javax.ws.rs.*;
import java.util.List;


@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {

    UserDao userDao= new UserDao();

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {
        return userDao.userById(userId);
    }

    @GET
    public List<User> getUser()  {
        return userDao.listUsers();
    }

    @DELETE
    @Path("/delete/{userId}")
    public void deleteUser(@PathParam("userId") Long userId){
        userDao.delete(userDao.userById(userId));
    }

    @POST
    @Path("/creation")
    public void creationUser(User user){
        User user1 = new User();

        if (!user1.getNom().isEmpty() && !user1.getPrenom().isEmpty()){
            user1.setNom(user.getNom());
            user1.setPrenom(user.getPrenom());
            user1.setFicheU(user.getFicheU());
        }
        userDao.save(user1);
    }

    @PUT
    @Path("/modif/{userId}")
    public void updateUser(@PathParam("userId")Long userId, User user){

        User user1 = new User();
        user1.setNom(user.getNom());
        user1.setPrenom(user.getPrenom());
        user1.setFicheU(user.getFicheU());
        userDao.delete(userDao.userById(userId));
        user1.setId(userId);
        userDao.save(user1);
    }
}
