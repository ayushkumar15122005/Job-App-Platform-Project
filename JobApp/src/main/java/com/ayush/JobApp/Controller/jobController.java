package com.ayush.JobApp.Controller;

import com.ayush.JobApp.Model.jobPost;
import com.ayush.JobApp.repo.jobRepo;
import com.ayush.JobApp.service.jobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class jobController {

    @Autowired
    private jobPostService service;

    @GetMapping("/jobPosts")
    public List<jobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @PostMapping("/addJob")
    public jobPost addJob(@RequestBody jobPost jobPost) {
        return service.addJob(jobPost);
    }

    @GetMapping("/jobPosts/search/{keyword}")
    public List<jobPost> search(@PathVariable String keyword) {
        return service.search(keyword);
    }
    @PutMapping("/updateJob")
    public jobPost updateJob(@RequestBody jobPost jobPost) {
        return service.updateJob(jobPost);
    }
    @DeleteMapping("/deleteJob/{jobId}")
    public jobPost deleteJob(@PathVariable int jobId) {
        return service.deleteJob(jobId);
    }
}