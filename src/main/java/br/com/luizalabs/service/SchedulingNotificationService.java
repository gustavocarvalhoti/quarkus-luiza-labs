package br.com.luizalabs.service;

import br.com.luizalabs.model.SchedulingNotification;
import br.com.luizalabs.repository.SchedulingNotificationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SchedulingNotificationService {

    @Inject
    SchedulingNotificationRepository schedulingNotificationRepository;

    public void persist(SchedulingNotification schedulingNotification) {
        schedulingNotificationRepository.persistAndFlush(schedulingNotification);
    }

    public SchedulingNotification findById(Long id) {
        return schedulingNotificationRepository.findById(id);
    }

    public List<SchedulingNotification> listAll() {
        return schedulingNotificationRepository.listAll();
    }
}