package com.wanted.siplanet.jobpost.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "user_id", length = 100)
    private String userId;      // 사용자 아이디

    @Column(name = "user_nm", length = 200, nullable = false)
    private String userNm;      // 사용자 이름

}
