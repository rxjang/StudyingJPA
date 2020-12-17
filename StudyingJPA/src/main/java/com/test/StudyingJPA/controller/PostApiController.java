package com.test.StudyingJPA.controller;

import com.test.StudyingJPA.dto.PostsSaveRequestDto;
import com.test.StudyingJPA.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    /*
        @ReqiuredArgsConstructor를 통해 final이 선언된 모든 필드를 생성한다.
     */

    private final PostService postService;

    @PostMapping("/api/vi/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);
    }
}
