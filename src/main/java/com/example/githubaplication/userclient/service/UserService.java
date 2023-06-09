package com.example.githubaplication.userclient.service;

import com.example.githubaplication.apiConect.DTO.BranchDtos;
import com.example.githubaplication.apiConect.DTO.DevelopDtos;
import com.example.githubaplication.apiConect.DTO.RepositoryDtos;
import com.example.githubaplication.apiConect.service.GitHubService;
import com.example.githubaplication.mapper.MapStructMapper;
import com.example.githubaplication.userclient.dto.UserRepositoryDtos;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserService {
    private final GitHubService gitHubService;
    private final MapStructMapper mapper;


    public ResponseEntity<?> getRepositoryforName(String userName){
        List<RepositoryDtos> gitRepositories = getAllRepositoriesByUsername(userName);
        List<RepositoryDtos> filteredRepositories = removeForksFromRepositories(gitRepositories);

        List<UserRepositoryDtos> repositories = filteredRepositories.stream()
                .map(repositoryDtos -> {
                    List<BranchDtos> gitHubBranches = getBranchesByNameRepoAndDevelopName(userName, repositoryDtos.name());
                    return mapper.gitHubRepoBranchesToClient(repositoryDtos, gitHubBranches);
                }).collect(Collectors
                        .toList());
        return ResponseEntity.ok(repositories);
    }
    private List<RepositoryDtos> removeForksFromRepositories(List<RepositoryDtos> repositories) {
        return repositories.stream()
                .filter(gitHubRepositoryDTO -> !gitHubRepositoryDTO.fork())
                .collect(Collectors.toList());
    }
    private List<BranchDtos> getBranchesByNameRepoAndDevelopName(String developName,String repositoryName){
        return Arrays.stream(gitHubService.getBranchUserReposDevName(developName,repositoryName))
                .toList();
    }
    private List<RepositoryDtos> getAllRepositoriesByUsername(String userName) {
        return Arrays.stream(gitHubService.getUserRepos(userName))
                .toList();
    }
}
