package com.ayush.JobApp.repo;

import com.ayush.JobApp.Model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<user,Integer> {
    user findByUsername(String username);
}
