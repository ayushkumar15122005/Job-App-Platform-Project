package com.ayush.JobApp.service;

import com.ayush.JobApp.Model.jobPost;
import com.ayush.JobApp.repo.jobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class jobPostService {

    @Autowired
    private jobRepo repo;

    // Logic to add a job
    public void addJob(jobPost jobPost) {
        repo.save(jobPost);
    }

    // Logic to return all jobs
    public List<jobPost> getAllJobs() {
        return repo.findAll();
    }

    // Logic to search for specific jobs
    public List<jobPost> search(String keyword) {
        return repo.findByJobProfileContainingIgnoreCase(keyword);
    }

    // Logic to get a single job by ID
    public jobPost getJob(int jobId) {
        return repo.findById(jobId).orElse(new jobPost());
    }

    // Logic to update an existing job
    public void updateJob(jobPost jobPost) {
        repo.save(jobPost);
    }

    // Logic to delete a job
    public void deleteJob(int jobId) {
        repo.deleteById(jobId);
    }
}