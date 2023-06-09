package com.example.githubaplication.apiConect.DTO;

import lombok.Builder;

@Builder
public record RepositoryDtos(String name, DevelopDtos developDtos,Boolean fork) {
}
