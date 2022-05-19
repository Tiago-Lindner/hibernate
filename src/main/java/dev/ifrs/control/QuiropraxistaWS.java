package dev.ifrs.control;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Quiropraxista;

@Path("/quiro")
@Transactional
public class QuiropraxistaWS {
    

    @GET
    @Path("/salvar/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Quiropraxista salvar(@PathParam("nome") String nome) {
        Quiropraxista pac = new Quiropraxista();
        pac.setNome(nome);
        pac.persist();
        return pac;
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Quiropraxista> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Quiropraxista.listAll();
    }

}
