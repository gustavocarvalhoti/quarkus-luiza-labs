package br.com.luizalabs.service;

import br.com.luizalabs.model.Receiver;
import br.com.luizalabs.model.SchedulingNotification;
import br.com.luizalabs.repository.SchedulingNotificationRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SchedulingNotificationService {

    @Inject
    SchedulingNotificationRepository schedulingNotificationRepository;

    @Inject
    ReceiverService receiverService;

    public void persist(SchedulingNotification schedulingNotification) {
        schedulingNotificationRepository.persistAndFlush(schedulingNotification);
    }

    public SchedulingNotification findById(Long id) {
        return schedulingNotificationRepository.findById(id);
    }

    public SchedulingNotification findByMessage(String message) {
        return schedulingNotificationRepository.find("message", message).firstResult();
    }

    public List<SchedulingNotification> listAll() {
        return schedulingNotificationRepository.listAll();
    }

    /**
     * Delete Receivers and notification
     *
     * @param message
     */
    @Transactional
    public void deleteByMessage(String message) {
        PanacheQuery<SchedulingNotification> notifications = schedulingNotificationRepository.find("message", message);
        notifications.stream().forEach(notification -> {
            Receiver receiver = receiverService.findById(notification.getReceiverId());
            notification.delete();
            receiver.delete();
        });
    }
}