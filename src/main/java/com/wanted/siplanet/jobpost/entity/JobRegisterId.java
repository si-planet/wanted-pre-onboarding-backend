package com.wanted.siplanet.jobpost.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


/**
*   복합 PK 키 클래스
* */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRegisterId implements Serializable {
    private Long jpNum;         // 채용 공고 번호
    private String userId;      // 지원자(사용자) 아이디

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRegisterId that = (JobRegisterId) o;
        return Objects.equals(jpNum, that.jpNum) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jpNum, userId);
    }
}
