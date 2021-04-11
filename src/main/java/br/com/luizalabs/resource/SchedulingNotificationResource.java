package br.com.luizalabs.resource;

import br.com.luizalabs.model.Receiver;
import br.com.luizalabs.model.SchedulingNotification;
import br.com.luizalabs.service.ReceiverService;
import br.com.luizalabs.service.SchedulingNotificationService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/scheduling-notification")
public class SchedulingNotificationResource {

    @Inject
    SchedulingNotificationService schedulingNotificationService;
    @Inject
    ReceiverService receiverService;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void persist(SchedulingNotification schedulingNotification) {
        // Persist all Receivers
        List<Receiver> receiverList = receiverService.persistAll(schedulingNotification.getReceivers());

        // Persist all SchedulingNotification
        receiverList.stream().forEach(receiver -> {
            SchedulingNotification notification = new SchedulingNotification(schedulingNotification);
            notification.setReceiverId(receiver.getId());
            notification.setCreatedAt(LocalDateTime.now());
            schedulingNotificationService.persist(notification);
        });
    }

    @PATCH
    @Path("/cancel/{id}")
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void cancel(@PathParam(value = "id") Long id) {
        SchedulingNotification notification = schedulingNotificationService.findById(id);
        if (notification == null) {
            throw new RuntimeException("This notification is invalid.");
        }

        notification.setStatus("canceled");
        schedulingNotificationService.persist(notification);
    }

    @PATCH
    @Path("/send/{id}")
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void send(@PathParam(value = "id") Long id) {
        SchedulingNotification notification = schedulingNotificationService.findById(id);
        if (notification == null || notification.getStatus().equals("canceled")) {
            throw new RuntimeException("This notification is invalid or was canceled.");
        }

        notification.setStatus("send");
        schedulingNotificationService.persist(notification);
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<SchedulingNotification> listAll() {
        List<SchedulingNotification> result = schedulingNotificationService.listAll();
        result.stream().forEach(notification -> {
            notification.setReceiver(receiverService.findById(notification.getReceiverId()));
        });

        return result;
    }
}