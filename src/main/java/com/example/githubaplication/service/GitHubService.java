package com.example.githubaplication.service;


import com.example.githubaplication.model.GitHubDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Slf4j
public class GitHubService {

    private RestTemplate restTemplate = new RestTemplate();
    public GitHubDto getUser(){
        String response = restTemplate.getForObject("https://api.github.com/users/Bartek2463/repos", String.class);

        log.info(response);

        return  null;
    }
}
