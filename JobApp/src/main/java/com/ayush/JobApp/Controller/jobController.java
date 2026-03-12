package com.ayush.JobApp.Controller;

import com.ayush.JobApp.Model.jobPost;
import com.ayush.JobApp.repo.jobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class jobController {

    @Autowired
    private jobRepo repo;

    @GetMapping("/jobPosts")
    public List<jobPost> getAllJobs() {
        return repo.findAll();
    }

    @PostMapping("/addJob")
    public jobPost addJob(@RequestBody jobPost jobPost) {
        return repo.save(jobPost);
    }

    @GetMapping("/jobPosts/search/{keyword}")
    public List<jobPost> search(@PathVariable String keyword) {
        return repo.findByJobProfileContainingIgnoreCase(keyword);
    }
}