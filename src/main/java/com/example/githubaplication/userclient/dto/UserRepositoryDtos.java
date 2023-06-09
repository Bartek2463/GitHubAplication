package com.example.githubaplication.userclient.dto;

import com.example.githubaplication.userclient.dto.UserBranchDtos;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRepositoryDtos {
    private String name;
    private String ownerLogin;
    private List<UserBranchDtos> branches;
}
