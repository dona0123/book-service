package org.example.memorydatabase.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.memorydatabase.user.model.UserEntity;
import org.example.memorydatabase.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class userApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        userService.delete(id);
    }
    @GetMapping("/id/{id}")
    public UserEntity findById(
            @PathVariable Long id
    ){
        var response = userService.findById(id);
        return response.get();
    }
    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam int score
    ){
        return userService.filterScore(score);
    }
}
