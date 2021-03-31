package fr.istic.taa.jaxrs.rest;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.dao.generic.FicheDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/fiche")
@Produces({"application/json", "application/xml"})
public class FicheResource {

    FicheDao ficheDao1= new FicheDao(EntityManagerHelper.getEntityManager());

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {

        return ficheDao1.ficheById(ficheId);
    }

    @GET

    public List<Fiche> getFiche()  {

        return ficheDao1.listFiche();
    }
}
