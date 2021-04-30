package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.domain.Tags;

import javax.ws.rs.*;
import java.util.List;


@Path("/tags")
@Produces({"application/json", "application/xml"})

public class TagResource {
    TagDao tagDao= new TagDao();

    @GET
    @Path("/{tagId}")
    public Tags getTagById(@PathParam("tagId") Long tagId)  {
        return tagDao.tagsById(tagId);
    }

    @GET
    public List<Tags> getTags()  {
        return tagDao.listTags();
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
