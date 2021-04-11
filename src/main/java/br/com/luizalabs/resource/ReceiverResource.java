package br.com.luizalabs.resource;

import br.com.luizalabs.model.Receiver;
import br.com.luizalabs.service.ReceiverService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/receiver")
public class ReceiverResource {

    @Inject
    ReceiverService receiverService;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void persist(Receiver receiver) {
        receiverService.persist(receiver);
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<Receiver> listAll() {
        return receiverService.listAll();
    }
}
