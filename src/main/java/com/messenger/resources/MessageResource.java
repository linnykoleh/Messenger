package com.messenger.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN) /* return format of response */
    public String getMessages(){
        return "Hello world!";
    }
}
