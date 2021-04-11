package br.com.luizalabs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SchedulingNotificationRepository implements PanacheRepository<br.com.luizalabs.model.SchedulingNotification> {
}
