package com.example.githubaplication.controller;

import com.example.githubaplication.model.GitHubDto;
import com.example.githubaplication.service.GitHubService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GitHubController {
    private final GitHubService gitHubService;

    @GetMapping("/repos")
    public GitHubDto gitHubDto(){
        return gitHubService.getUser();
    }
}
