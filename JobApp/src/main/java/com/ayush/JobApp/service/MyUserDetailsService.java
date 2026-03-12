package com.ayush.JobApp.service;

import com.ayush.JobApp.Model.UserPrincipal;
import com.ayush.JobApp.Model.user;
import com.ayush.JobApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user=repo.findByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}
