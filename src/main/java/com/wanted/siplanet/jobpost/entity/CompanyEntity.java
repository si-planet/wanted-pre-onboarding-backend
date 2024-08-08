package com.wanted.siplanet.jobpost.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
@Table(name = "company")
public class CompanyEntity {

    @Id
    @Column(name = "comp_id", length = 100)
    private String compId;     // 기업 아이디

    @Column(name = "comp_nm", length = 200, nullable = false)
    private String compNm;     // 기업명

}