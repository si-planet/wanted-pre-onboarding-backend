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
@Table(name = "company")
public class CompanyEntity {

    @Id
    @Column(name = "comp_id", length = 100)
    private String compId;     // 기업 아이디

    @Column(name = "comp_nm", length = 200, nullable = false)
    private String compNm;     // 기업명

}