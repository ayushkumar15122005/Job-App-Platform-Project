package com.ayush.JobApp.Controller;

import com.ayush.JobApp.Model.jobPost;
import com.ayush.JobApp.Model.user;
import com.ayush.JobApp.repo.UserRepo;
import com.ayush.JobApp.service.jobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    jobPostService service;
    @Autowired
    private UserRepo repo;

    @GetMapping("home")
    public String home(){
        return "home";
    }
    @GetMapping("addJob")
    public String addJob(){
        return "addJob";
    }
    @PostMapping("handleForm")
    public String handleForm(jobPost job){
        service.addJob(job);
        return "success";
    }
    @GetMapping("viewAllJobs")
    public ModelAndView view(ModelAndView mv){
        List<jobPost> jobs=service.getAllJobs();
        mv.addObject("jobPost",jobs);
        mv.setViewName("viewAllJobs");
        return mv;
    }
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @PostMapping("register")
    public void register(@RequestBody user user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }
}
