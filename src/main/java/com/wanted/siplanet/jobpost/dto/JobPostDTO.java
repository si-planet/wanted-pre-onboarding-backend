package com.wanted.siplanet.jobpost.dto;


import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class JobPostDTO {
    private Long jp_num;                // 채용공고번호
    private String nation;              // 국가
    private String region;              // 지역
    private String position;            // 채용 포지션
    private int rewards;                // 채용 보상금
    private String technic;             // 사용기술
    private String title;               // 채용 제목
    private String contents;            // 채용 내용
    private LocalDateTime created;      // 채용 공고 게시일
    private String comp_nm;             // 회사 이름

    public static JobPostDTO toJobPostDTOAll(JobPostEntity jpe) {
        JobPostDTO dto = new JobPostDTO();

        dto.setJp_num(jpe.getJpNum());
        dto.setRegion(jpe.getRegion());
        dto.setTechnic(jpe.getTechnic());
        dto.setTitle(jpe.getTitle());
        dto.setCreated(jpe.getCreated());
        dto.setComp_nm(jpe.getCe().getCompNm());

        return dto;
    }

    public static JobPostDTO toJobPostDTO(JobPostEntity jpe) {
        JobPostDTO dto = new JobPostDTO();

        dto.setJp_num(jpe.getJpNum());
        dto.setNation(jpe.getNation());
        dto.setRegion(jpe.getRegion());
        dto.setPosition(jpe.getPosition());
        dto.setRewards(jpe.getRewards());
        dto.setTechnic(jpe.getTechnic());
        dto.setTitle(jpe.getTitle());
        dto.setContents(jpe.getContents());
        dto.setCreated(jpe.getCreated());
        dto.setComp_nm(jpe.getCe().getCompNm());

        return dto;
    }
}
