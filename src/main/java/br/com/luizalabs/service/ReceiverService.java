package br.com.luizalabs.service;

import br.com.luizalabs.model.Receiver;
import br.com.luizalabs.repository.ReceiverRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ReceiverService {

    @Inject
    ReceiverRepository receiverRepository;

    public void persist(Receiver receiver) {
        receiverRepository.persistAndFlush(receiver);
    }

    public List<Receiver> persistAll(List<Receiver> receiverList) {
        receiverList.stream().forEach(receiver -> persist(receiver));
        return receiverList;
    }

    public List<Receiver> listAll() {
        return receiverRepository.listAll();
    }

    public Receiver findById(Long id) {
        return receiverRepository.findById(id);
    }

    @Transactional
    public void delete(String name) {
        PanacheQuery<Receiver> receiver = receiverRepository.find("name", name);
        receiver.stream().forEach(Receiver::delete);
    }
}
