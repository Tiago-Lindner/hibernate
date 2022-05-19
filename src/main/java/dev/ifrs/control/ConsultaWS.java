package dev.ifrs.control;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.model.Consulta;
import dev.ifrs.model.Paciente;

@Path("/consulta")
@Transactional
public class ConsultaWS {

   @GET
   @Path("/salvar/{texto}/{idPac}")
   @Produces(MediaType.APPLICATION_JSON)
   public Consulta salvar(@PathParam("texto") String texto, @PathParam("idPac") Long idPac){

    Consulta consulta = new Consulta();
    consulta.setSituacao(texto);
    consulta.persistAndFlush();

    Paciente pac = Paciente.findById(idPac);
    if (pac == null)
        throw new BadRequestException("Paciente não encontrado"); 

//ver post
    pac.addConsulta(consulta);
    consulta.setPaciente(pac);
    pac.persistAndFlush();

    return consulta;
   }
    
}
