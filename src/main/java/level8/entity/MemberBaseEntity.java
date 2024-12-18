package level8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
//  작성일 필드는 JPA Auditing 활용
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class MemberBaseEntity {

    // 작성일
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
