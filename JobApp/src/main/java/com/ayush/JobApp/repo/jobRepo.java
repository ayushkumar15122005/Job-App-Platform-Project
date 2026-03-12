package com.ayush.JobApp.repo;

import com.ayush.JobApp.Model.jobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface jobRepo extends JpaRepository<jobPost, Integer> {

    // 1. DSL Query: Find by profile containing a keyword (case-insensitive)
    List<jobPost> findByJobProfileContainingIgnoreCase(String keyword);


    // 2. Complex Search: Profile OR Description
    List<jobPost> findByJobProfileContainingOrJobDescContainingIgnoreCase(String profile, String desc);
}