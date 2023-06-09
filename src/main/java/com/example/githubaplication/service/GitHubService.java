package com.example.githubaplication.service;


import com.example.githubaplication.model.GitHubDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Slf4j

public class GitHubService {

private static  final String BRANCH_URL = "https://api.github.com/repos/{Develop}/{repository}/branches";
private static  final String REPO_URL = "https://api.github.com/users/{DEVELOP}/repos";

    private RestTemplate restTemplate = new RestTemplate();


    public GitHubDto getUserRepos(){
        String response = restTemplate.getForObject(REPO_URL, String.class);

        log.info(response);

        return  null;
    }
    public GitHubDto getBranchByRepository(){
        String response = restTemplate.getForObject(BRANCH_URL,String.class);
        log.info(response);
        return null;
    }
}
