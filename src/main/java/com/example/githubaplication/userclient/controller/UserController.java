package com.example.githubaplication.userclient.controller;

import com.example.githubaplication.Exception.CustomException;
import com.example.githubaplication.userclient.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@RestController
@RequestMapping("/user")
public class UserController {


private final UserService userService;


    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllOwnRepositories(@PathVariable String userName, @RequestHeader(HttpHeaders.ACCEPT) String acceptHeader) {
        if (!acceptHeader.equals("application/json")) {
            CustomException customExceptionError = new CustomException(406, "Invalid Accept header. Only 'application/json' is allowed.");
            return ResponseEntity.status(customExceptionError.getStatus()).contentType(MediaType.APPLICATION_JSON).body(customExceptionError);
        }
        return userService.getRepositoryforName(userName);
    }

}
