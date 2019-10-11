package com.sda.gym.Service;

import com.sda.gym.Entity.Client;
import com.sda.gym.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    private ClientRepository repository;

    @Autowired
    public ClientService (ClientRepository repository) {
        this.repository = repository;
    }

    public Client add(Client client) {
        return repository.save(client);
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client getById(int id) {
        return this.repository.findById(id).get();
    }

    public void delete (int userID){
        this.repository.deleteById(userID);
    }

    public Client update(Client client) {
        return repository.save(client);
    }

}
