package com.scripBox.apitest;

import com.scripBox.apitest.pojos.Credentials;
import com.scripBox.apitest.pojos.ResToken;
import com.scripBox.apitest.pojos.Unknown;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public interface ScripBoxApi {



    @POST
    @Path("register")
    ResToken RegisterAPI(Credentials credentials);

    @POST
    @Path("login")
    ResToken LoginAPI(Credentials credentials);

    @GET
    @Path ("user/profile/{user_id}")
    Unknown ProfileAPI (@PathParam("user_id") Integer id, @HeaderParam("Authorization") String token );

    @GET
    @Path("resources/unknown")
    Unknown ResourceAPI(@HeaderParam("Authorization") String token);


}
