package com.wanted.siplanet.jobpost.entity;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "jobpost")
public class JobPostEntity extends BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "jp_num")
    private Long jpNum;                // 채용공고번호

    @Column (nullable = false)
    private String nation;              // 국가

    @Column (nullable = false)
    private String region;              // 지역

    @Column (nullable = false)
    private String position;            // 채용 포지션

    @Column (nullable = false)
    private int rewards;                // 채용 보상금

    @Column (nullable = false)
    private String technic;             // 사용기술

    @Column (nullable = false)
    private String title;               // 채용 제목

    @Column (length = 2000 , nullable = false)
    private String contents;            // 채용 내용

    @ManyToOne
    @JoinColumn(name = "comp_id")
    private CompanyEntity ce;

    public static JobPostEntity toSaveEntity(JobPostDTO dto){
        JobPostEntity jp = new JobPostEntity();

        jp.setNation(dto.getNation());
        jp.setRegion(dto.getRegion());
        jp.setPosition(dto.getPosition());
        jp.setRewards(dto.getRewards());
        jp.setTechnic(dto.getTechnic());
        jp.setTitle(dto.getTitle());
        jp.setContents(dto.getContents());

        return jp;
    }

}
