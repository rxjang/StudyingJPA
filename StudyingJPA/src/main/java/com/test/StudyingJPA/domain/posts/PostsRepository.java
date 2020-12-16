package com.test.StudyingJPA.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*
        JpaRepository: DB Layer 접근자
        인터페이스로 생성
        JpaRepository<Entity 클래스, pk 타입>을 상속하면 기본적인 CRUD 메소드 자동 생성됨
        @Repository 추가할 필요 없음
        entity 클래스와 기본 entity repository는 함께 위치해야 함
     */
}
