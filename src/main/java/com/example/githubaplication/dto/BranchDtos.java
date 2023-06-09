package com.example.githubaplication.dto;

import lombok.*;

@Builder
public record BranchDtos(String name,CommitDtos commitDtos) {

}
