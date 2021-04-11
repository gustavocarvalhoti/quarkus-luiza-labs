package br.com.luizalabs.service;

import br.com.luizalabs.model.Receiver;
import br.com.luizalabs.repository.ReceiverRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReceiverService {

    @Inject
    ReceiverRepository receiverRepository;

    public void persist(Receiver receiver) {
        receiverRepository.persist(receiver);
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
}
