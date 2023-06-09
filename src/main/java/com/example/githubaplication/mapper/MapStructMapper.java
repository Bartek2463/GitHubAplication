package com.example.githubaplication.mapper;


import com.example.githubaplication.apiConect.DTO.BranchDtos;
import com.example.githubaplication.apiConect.DTO.RepositoryDtos;
import com.example.githubaplication.userclient.dto.UserBranchDtos;
import com.example.githubaplication.userclient.dto.UserRepositoryDtos;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Component
public class MapStructMapper {

    public UserRepositoryDtos gitHubRepoBranchesToClient(RepositoryDtos gitHubRepositoryDTO, List<BranchDtos> branchDtosList) {
        UserRepositoryDtos repositoryDtos = new UserRepositoryDtos();
        List<UserBranchDtos> gitHubBranchDTOList = new ArrayList<>();
        for (BranchDtos branchDtos : branchDtosList) {
           UserBranchDtos userBranchDtos = new UserBranchDtos();
            userBranchDtos.setSha(branchDtos.commitDtos().getSha());
            userBranchDtos.setName(branchDtos.name());
            gitHubBranchDTOList.add(userBranchDtos);
        }
        repositoryDtos.setBranches(gitHubBranchDTOList);
        repositoryDtos.setOwnerLogin(gitHubRepositoryDTO.developDtos().getLogin());
        repositoryDtos.setName(gitHubRepositoryDTO.name());
        return repositoryDtos;
    }
}
