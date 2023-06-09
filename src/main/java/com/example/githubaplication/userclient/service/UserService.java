package com.example.githubaplication.userclient.service;

import com.example.githubaplication.apiConect.DTO.RepositoryDtos;
import com.example.githubaplication.apiConect.service.GitHubService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class UserService {
    private final GitHubService gitHubService;
    private List<RepositoryDtos> repositoryDtos;


    public ResponseEntity<Object> getRepositoryforName(String userName){
        List<RepositoryDtos> gitRepositories = Arrays.stream(gitHubService.getUserRepos(userName)).toList();
        List<RepositoryDtos> filterFork = repositoryDtos.stream().filter(rep -> !rep.fork()).toList();
        filterFork.stream()
                .map(git->{})
    }
}
