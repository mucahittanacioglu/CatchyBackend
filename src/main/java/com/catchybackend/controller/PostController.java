package com.catchybackend.controller;

import com.catchybackend.business.concrete.PostService;
import com.catchybackend.models.Post;
import com.ts.core.security.RequiredRoles;
import com.ts.core.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/addPost")
    @RequiredRoles(Role.ADD)
    public ResponseEntity<String> createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
    @DeleteMapping("/deletePost")
    @RequiredRoles(Role.DELETE)
    public ResponseEntity<String> deletePost(@RequestParam(name = "id") long id){
        return postService.deletePost(id);
    }
//TODO: İnterfaceler üzerinden bağımlılık oluştur.
}
