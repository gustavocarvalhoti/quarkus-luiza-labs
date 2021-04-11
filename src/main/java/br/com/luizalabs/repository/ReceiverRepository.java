package br.com.luizalabs.repository;

import br.com.luizalabs.model.Receiver;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReceiverRepository implements PanacheRepository<Receiver> {
}
