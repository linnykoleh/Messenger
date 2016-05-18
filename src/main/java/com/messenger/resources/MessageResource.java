package com.messenger.resources;


import com.messenger.model.Message;
import com.messenger.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageResource {

    final MessageService service = new MessageService();

/*
    @GET
    @Produces(MediaType.TEXT_PLAIN)  return format of response
    public String getMessages(){
        return "Hello world!";
    }
*/

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
        return service.getAllMessages();
    }
}
