package com.br.menu.controler;

import com.br.menu.domain.Recipes;
import com.br.menu.service.RecipesService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@Path("/recipes")
public class RecipesController {

    RecipesService service = new RecipesService();

    public RecipesController() throws SQLException {
    }

    @GET
    @Produces("application/json")
    public List<Recipes> getALlRecipes() {
        return service.getAllRecipes();
    }

    @GET
    @Produces("application/json")
    @PathParam("{id}")
    public List<Recipes> getById() {
        return service.getAllRecipes();
    }

    @POST
    @Consumes("application/json")
    public Response insertRecipes(Recipes recipes, @Context UriInfo uriInfo) {
        service.insertRecipes(recipes);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(recipes.getId()));
        return Response.accepted().build();

    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public  Response updateRecipes(Recipes recipes,@PathParam("id")Integer id){
        service.updateRecipes(recipes,id);
        return  Response.ok().build();
    }


}
