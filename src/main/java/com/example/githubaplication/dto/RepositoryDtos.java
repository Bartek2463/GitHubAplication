package com.example.githubaplication.dto;

import lombok.Builder;

@Builder
public record RepositoryDtos(String name, DevelopDtos developDtos,Boolean fork) {
}
