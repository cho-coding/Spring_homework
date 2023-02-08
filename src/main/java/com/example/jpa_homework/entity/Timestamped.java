package com.example.jpa_homework.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

// inheritor = "상속인"
@Getter
@MappedSuperclass
//https://webcoding-start.tistory.com/53
// AuditingEntityListener.class 는 자동으로 시간 생성
@EntityListeners(AuditingEntityListener.class)

//시간 관련 메서드
public class Timestamped {

    @CreatedDate // 작성날짜
    private LocalDateTime createdAt;

    @LastModifiedDate // 최종 수정일
    private LocalDateTime modifiedAt;
}
