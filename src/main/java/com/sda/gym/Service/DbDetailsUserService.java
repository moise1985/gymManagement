package com.sda.gym.Service;

import com.sda.gym.Entity.Role;
import com.sda.gym.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.sda.gym.Entity.User;

@Service
public class DbDetailsUserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors
                .toList());

        // sau
        List <SimpleGrantedAuthority> authorities1 = new ArrayList<>();
        for (Role r: user.getRoles())
        {
            SimpleGrantedAuthority a = new SimpleGrantedAuthority(r.getName());
            authorities1.add(a);

        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities1);
    }

}
