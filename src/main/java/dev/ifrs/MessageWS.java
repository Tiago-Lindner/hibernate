package dev.ifrs;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Message;
import dev.ifrs.model.User;

@Path("/message")
@Transactional
public class MessageWS {

   @GET
   @Path("/save/{text}/{idUser}")
   @Produces(MediaType.APPLICATION_JSON)
   public Message save(@PathParam("text") String text, @PathParam("idUser") Long idUser) {

      Message message = new Message();
      message.setText(text);
      message.persistAndFlush();

      User user = User.findById(idUser);
      if (user == null)
         throw new BadRequestException("User not found");

      user.addMessage(message);
      user.persistAndFlush();

      return message;
   }

   @GET
   @Path("/delete/{idMessage}")
   @Produces(MediaType.APPLICATION_JSON)
   public void delete(@PathParam("idMessage") Long idMessage) {

      Message message = Message.findById(idMessage);
      if (message == null)
         throw new BadRequestException("Message not found");

      message.deleteAll();   
      message.persistAndFlush();

     
   }

}