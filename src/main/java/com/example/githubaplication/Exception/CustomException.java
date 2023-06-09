package com.example.githubaplication.Exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CustomException {
    private int status;
    private String message;
}