package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {

    UserDao userDao= new UserDao();

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Long userId)  {
        return Response.status(200).entity(userDao.userById(userId)).build();
    }

    @GET
    public Response getUser()  {
        return Response.status(200).entity(userDao.listUsers()).build();
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
