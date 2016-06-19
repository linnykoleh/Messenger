package com.messenger.resources;


import com.messenger.model.Message;
import com.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON) /* может быть аннотирован как класс так и метод */  /*ожидаем получить JSON Должен быть добавлен header Content-Type=application/json*/
@Produces(MediaType.APPLICATION_JSON) /* может быть аннотирован как класс так и метод */
public class MessageResource {

    final MessageService service = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON) /*format of response*/
    public List<Message> getMessages(){
        return service.getAllMessages();
    }

    @GET /*read resources*/
    @Path("/{messageId}")
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

    @POST /*creating new resources*/
    public Message addMessage(Message message){
        return service.addMessage(message);
    }

    @PUT /*updating resources*/
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId, Message message){
        message.setId(messageId);
        return service.updateMessage(message);
    }

    @DELETE /*deleting resources*/
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long messageId){
        service.removeMessage(messageId);
    }

}
