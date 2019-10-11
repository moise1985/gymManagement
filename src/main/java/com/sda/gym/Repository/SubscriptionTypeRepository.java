package com.sda.gym.Repository;

import com.sda.gym.Entity.Subscription;
import com.sda.gym.Entity.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Integer> {


}
