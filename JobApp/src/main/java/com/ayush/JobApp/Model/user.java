package com.ayush.JobApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "User Data")
@Data
public class user {
    @Id
    private int id;
    private String username;
    private String password;
}
