package com.messenger.resources;


import com.messenger.model.Message;
import com.messenger.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Produces(MediaType.APPLICATION_XML) /*format of response*/
    public List<Message> getMessages(){
        return service.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") long messageId){
        /*
             http://localhost:8080/messenger/webapi/messages/5

             messageId = 5

             Аннотация @PathParam нужна для получения парамера как messageId
             На момент получения мессаджа мы можем не знать id мессаджа

             Jersey передаст значение messageId и с указанным типом в аргументе метода если
             аргумент будет аннотирован аннотацией @PathParam("messageId")
        */

        return service.getMessage(messageId);
    }


}
