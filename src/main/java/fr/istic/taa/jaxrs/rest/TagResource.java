package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.domain.Tags;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/tags")
@Produces("application/json")
@Consumes("application/json")
public class TagResource {
    TagDao tagDao= new TagDao();

    @GET
    @Path("/{tagId}")
    public Response getTagById(@PathParam("tagId") Long tagId)  {
        return Response.status(200).entity(tagDao.tagsById(tagId)).build();
    }

    @GET
    public Response getTags()  {
        return Response.status(200).entity(tagDao.listTags()).build();
    }

    @DELETE
    @Path("/delete/{tagId}")
    public void deleteTag(@PathParam("tagId") Long tagId){
        tagDao.delete(tagDao.tagsById(tagId));
    }

    @POST
    @Path("/creation")
    public void creationTag(Tags tag){
        Tags tag1 = new Tags();

        if (!tag1.getTag().isEmpty()){
            tag1.setTag(tag.getTag());
            tag1.setFicheT(tag.getFicheT());
        }
        tagDao.save(tag1);
    }

    @PUT
    @Path("/modif/{tagId}")
    public void updateTag(@PathParam("tagId")Long tagId, Tags tag){

        Tags tag1= new Tags();
        tag1.setTag(tag.getTag());
        tag1.setFicheT(tag.getFicheT());
        tagDao.delete(tagDao.tagsById(tagId));
        tag1.setId(tagId);
        tagDao.save(tag1);
    }
}
