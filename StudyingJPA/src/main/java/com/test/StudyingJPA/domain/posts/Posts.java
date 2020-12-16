package com.test.StudyingJPA.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    /*
        @Entity 테이블과 링크될 클래스임을 나타냄
                entity 클래스에서는 절대 setter 메소드를 만들지 않는다.
     */
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성 규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
        @Column 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
                기본값 외 추가로 변경이 필요한 옵션이 있으면 사용
     */

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    /*
        @Builder 해당 클래스의 빌더 패턴 클래스를 생성
                 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
     */

}
