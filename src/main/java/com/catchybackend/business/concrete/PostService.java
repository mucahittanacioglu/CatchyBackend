package com.catchybackend.business.concrete;

import com.catchybackend.dataaccess.PostRepository;
import com.catchybackend.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public ResponseEntity<String> createPost(Post post){
        var result = postRepository.save(post).toString();
        return ResponseEntity.ok().body(result);
    }
    public ResponseEntity<String> deletePost(long id){
        var postToDelete = postRepository.findById(id);

        if(postToDelete.isPresent()) {
            postRepository.delete(postToDelete.get());
            return ResponseEntity.ok().body("Post:"+postToDelete.get()+" deleted.");
        }
        return ResponseEntity.ok().body("The post is not in db");

    }
}
