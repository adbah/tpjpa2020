package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.FicheDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/fiche")
@Produces({"application/json", "application/xml"})

public class FicheResource {
    @GET
    @Path("/{idFiche}")
    public Fiche getFicheById(@PathParam("idFiche") Long idFiche)  {
        return new FicheDAO().findOne(idFiche);
    }

    @POST
    @Consumes("application/json")
    public Response ajouterFiche(
            @Parameter(description = "Enregistrement d'une fiche", required = true) Fiche fiche) {
        new FicheDAO().save(fiche);
        return Response.ok().entity("SUCCESS").build();
    }
}
