package com.test.StudyingJPA.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    /*
        @SpringBootTest 별다른 설정이 없으면 H2데이터베이스를 자동으로 실행해준다.
     */

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void savingPosts(){
        String title="테스트 게시글";
        String content="테스트 본문";

        postsRepository.save(Posts.builder()
                                    .title(title)
                                    .content(content)
                                    .author("rxforp@naver.com")
                                    .build());

        /*
            jpaRepository.save
            테이블에 insert/update 쿼리를 실행한다.
            id 값이 있다면 update, 없다면 insert쿼리가 실행된다.
         */

        //when
        List<Posts> postsList=postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}