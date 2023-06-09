package com.example.githubaplication.apiConect.service;


import com.example.githubaplication.apiConect.DTO.BranchDtos;
import com.example.githubaplication.apiConect.DTO.RepositoryDtos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Slf4j
public class GitHubService {

    private RestTemplate restTemplate;
    private static  final String BRANCH_URL = "https://api.github.com/repos/{Develop}/{repository}/branches";
    private static  final String REPO_URL = "https://api.github.com/users/{DEVELOP}/repos";

    public GitHubService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public RepositoryDtos[] getUserRepos(String developName){
        return restTemplate.getForEntity(REPO_URL, RepositoryDtos[].class,developName).getBody();
    }
    public BranchDtos[] getBranchUserReposDevName(String developName,String repoName){
        return restTemplate.getForEntity(BRANCH_URL, BranchDtos[].class,developName,repoName).getBody();
    }
}
