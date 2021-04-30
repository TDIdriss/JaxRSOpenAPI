package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/section")
@Produces({"application/json", "application/xml"})

public class SectionResource {
    SectionDao sectionDao= new SectionDao();

    @GET
    @Path("/{sectionId}")
    public Response getSectionById(@PathParam("sectionId") Long sectionId)  {
        return Response.status(200).entity(sectionDao.sectionById(sectionId)).build();
    }

    @GET
    public Response getSection()  {
        return Response.status(200).entity(sectionDao.listSection()).build();
    }

    @DELETE
    @Path("/delete/{sectionId}")
    public void deleteSection(@PathParam("sectionIdId") Long sectionId){
        sectionDao.delete(sectionDao.sectionById(sectionId));
    }

    @POST
    @Path("/creation")
    public void creationSection(Section section){
        Section section1 = new Section();

        if (!section.getSection().isEmpty()){
            section1.setSection(section.getSection());
            section1.setFicheS(section.getFicheS());
        }
            sectionDao.save(section1);
    }

    @PUT
    @Path("/modif/{sectionId}")
    public void updateSection(@PathParam("ficheId")Long sectionId, Section section){

        Section section1= new Section();
        section1.setSection(section.getSection());
        section1.setFicheS(section.getFicheS());
        sectionDao.delete(sectionDao.sectionById(sectionId));
        section1.setId(sectionId);
        sectionDao.save(section1);
    }
}
