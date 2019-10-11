package com.sda.gym.Repository;

import com.sda.gym.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);
    
}
