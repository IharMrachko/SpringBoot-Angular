package com.students.demo.security;

import com.students.demo.models.User;
import com.students.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SecurityDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
      User user =  userRepository.findByName(name);
       return new org.springframework.security.core.userdetails.User(
              user.getName(),
              user.getPassword(),
              Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
    }
}
