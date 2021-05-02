package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/fiche")
@Produces("application/json")
@Consumes("application/json")
public class FicheResource {

    FicheDao ficheDao= new FicheDao();

    @GET
    @Path("/{ficheId}")
    public Response getFicheById(@PathParam("ficheId") Long ficheId)  {
        return Response.status(200).entity(ficheDao.ficheById(ficheId)).build() ;
    }

    @GET
    public Response getFiche()  {
        return Response.status(200).entity(ficheDao.listFiche()).build();
    }

    @DELETE
    @Path("/delete/{ficheId}")
    public void deleteFiche(@PathParam("ficheId") Long ficheId){
        ficheDao.delete(ficheDao.ficheById(ficheId));
    }

    @POST
    @Path("/creation")
    public void creationFiche(Fiche fiche){
        Fiche fiche1 = new Fiche();


                if (!fiche.getLibelle().isEmpty() && !fiche.getDate().isEmpty() && !fiche.getLieu().isEmpty() && !fiche.getNote().isEmpty() && fiche.getOwner()!=null && fiche.getSectionF()!=null && fiche.getTagsF()!=null && !fiche.getTemps().isEmpty() && !fiche.getUrl().isEmpty());{

                    fiche1.setLibelle(fiche.getLibelle());
                    fiche1.setDate(fiche.getDate());
                    fiche1.setLieu(fiche.getLieu());
                    fiche1.setNote(fiche.getNote());
                    fiche1.setOwner(fiche.getOwner());
                    fiche1.setSectionF(fiche.getSectionF());
                    fiche1.setTagsF(fiche.getTagsF());
                    fiche1.setTemps(fiche.getTemps());
                    fiche1.setUrl(fiche.getUrl());
                }

        ficheDao.save(fiche1);

    }

    @PUT
    @Path("/modif/{ficheId}")
    public void updateFiche(@PathParam("ficheId")Long ficheId, Fiche fiche){
        Fiche fiche1 =new Fiche();

        fiche1.setLibelle(fiche.getLibelle());
        fiche1.setDate(fiche.getDate());
        fiche1.setLieu(fiche.getLieu());
        fiche1.setNote(fiche.getNote());
        fiche1.setOwner(fiche.getOwner());
        fiche1.setSectionF(fiche.getSectionF());
        fiche1.setTagsF(fiche.getTagsF());
        fiche1.setTemps(fiche.getTemps());
        fiche1.setUrl(fiche.getNote());
        ficheDao.delete(ficheDao.ficheById(ficheId));
        fiche1.setId(ficheId);
        ficheDao.save(fiche1);


    }



}
