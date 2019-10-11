package com.sda.gym.Service;


import com.sda.gym.Entity.SubscriptionType;
import com.sda.gym.Repository.SubscriptionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeService {

    private SubscriptionTypeRepository repository;

    @Autowired
    public SubscriptionTypeService(SubscriptionTypeRepository repository) { this.repository = repository; }

    public SubscriptionType add(SubscriptionType subscriptionType) {
        return repository.save(subscriptionType);
    }

    public List<SubscriptionType> getAll() {
        return repository.findAll();
    }

    public SubscriptionType getById(int id) {
        return this.repository.findById(id).get();
    }

    public void delete (int userID){
        this.repository.deleteById(userID);
    }

    public SubscriptionType update(SubscriptionType subscriptionType) {
        return repository.save(subscriptionType);
    }

}
