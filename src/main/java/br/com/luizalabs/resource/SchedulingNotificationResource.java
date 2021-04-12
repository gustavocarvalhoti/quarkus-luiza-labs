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
        List<Receiver> receivers = schedulingNotification.getReceivers();
        validateTypeNotification(schedulingNotification, receivers);

        // Persist all Receivers
        List<Receiver> receiverList = receiverService.persistAll(receivers);

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

    /**
     * Validate Receivers by your notification type
     */
    private void validateTypeNotification(SchedulingNotification schedulingNotification, List<Receiver> receivers) {
        receivers.stream().forEach(receiver -> {
            if (receiver.getName() == null) {
                throw new RuntimeException("This notification is invalid. Fill the name to continue.");
            }
        });

        if (schedulingNotification.getType().equals("whatsapp")) {
            receivers.stream().forEach(receiver -> {
                if (receiver.getWhatsapp() == null) {
                    throw new RuntimeException("This notification is invalid. Fill the whatsapp to continue.");
                }
            });
        } else if (schedulingNotification.getType().equals("email")) {
            receivers.stream().forEach(receiver -> {
                if (receiver.getEmail() == null) {
                    throw new RuntimeException("This notification is invalid. Fill the email to continue.");
                }
            });
        } else if (schedulingNotification.getType().equals("sms")) {
            receivers.stream().forEach(receiver -> {
                if (receiver.getPhone() == null) {
                    throw new RuntimeException("This notification is invalid. Fill the phone to continue.");
                }
            });
        } else if (schedulingNotification.getType().equals("push")) {
            receivers.stream().forEach(receiver -> {
                if (receiver.getCpf() == null) {
                    throw new RuntimeException("This notification is invalid. Fill the cpf to continue.");
                }
            });
        } else {
            throw new RuntimeException("The type " + schedulingNotification.getType() + " is invalid, select: [whatsapp, email, sms, push]");
        }
    }
}