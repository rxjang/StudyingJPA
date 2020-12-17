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
        /*
            @RequestBody    HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할을 함
            @RestController은 @Controller와 다르게 리턴값에 자동으로 @ResponseBody를 붙이게되어
                Http응답데이터(body)에 자바 각체가 매팽되어 전달됩니다.
         */
        return postService.save(requestDto);
    }
}
