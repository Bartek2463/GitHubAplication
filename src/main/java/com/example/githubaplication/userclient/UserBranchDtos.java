package com.example.githubaplication.userclient;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserBranchDtos {
   private String name;
     private String sha;
}
