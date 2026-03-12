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

    public void addJob(jobPost job){
        repo.save(job);
    }

    public List<jobPost> getAllJobs(){
        return repo.findAllJobs();
    }
}
