package com.sda.gym.Service;


import com.sda.gym.Entity.Subscription;
import com.sda.gym.Repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private SubscriptionRepository repository;

    @Autowired
    public SubscriptionService (SubscriptionRepository repository) { this.repository = repository; }

    public Subscription add(Subscription subscription) {
        return repository.save(subscription);
    }

    public List<Subscription> getAll() {
        return repository.findAll();
    }

    public Subscription getById(int id) {
        return this.repository.findById(id).get();
    }

    public void delete (int userID){
        this.repository.deleteById(userID);
    }

    public Subscription update(Subscription subscription) {
        return repository.save(subscription);
    }

}
