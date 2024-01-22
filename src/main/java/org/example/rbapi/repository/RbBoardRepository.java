package org.example.rbapi.repository;

import org.example.rbapi.domain.RbBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RbBoardRepository extends JpaRepository<RbBoard, String> {
     /*
    RbBoardRepository를 사용하기 위해,
    JpaRepository<RbBoard, String>에서
    RbBoard 라는 엔티티 클래스를 먼저 제공하고, RbBoard의 인덱스pk의 자료형을 선언해줍니다.

    기존에 이미 구현된 JPA 기능을 모두 사용 가능!!
    */
}
