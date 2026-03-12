package com.ayush.JobApp.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity // Crucial: This makes the class visible to Hibernate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class jobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    private String jobProfile;
    private String jobDesc;
    private int reqExperience;

    @ElementCollection(fetch = FetchType.EAGER) // Maps the List to a separate table
    @CollectionTable(name = "job_tech_stack", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "technology")
    private List<String> postTechStack;
}