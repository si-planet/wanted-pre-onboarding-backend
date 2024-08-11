package com.wanted.siplanet.jobpost.service;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import com.wanted.siplanet.jobpost.entity.CompanyEntity;
import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import com.wanted.siplanet.jobpost.repository.CompanyRepository;
import com.wanted.siplanet.jobpost.repository.JobPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Transactional
class JobPostServiceTest {

    @Autowired JobPostService jobPostService;
    @Autowired JobPostRepository jobPostRepository;
    @Autowired CompanyRepository companyRepository;

    /**
     *  채용 공고 작성
     * */
    @Test
    void jobPostCreate() {
        // given
        JobPostDTO jobPost = new JobPostDTO();
        jobPost.setNation("한국");
        jobPost.setRegion("서울");
        jobPost.setPosition("백엔드");
        jobPost.setRewards(1000000);
        jobPost.setTechnic("java");
        jobPost.setTitle("codeit 하반기 백엔드 개발자 채용");
        jobPost.setContents("상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.");

        CompanyEntity ce = new CompanyEntity();
        ce.setCompId("codeit");

        JobPostEntity jpe;
        if(companyRepository.findById(ce.getCompId()).isPresent())
            jpe = JobPostEntity.toSaveEntity(jobPost, ce);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        // when
        jpe = jobPostService.jobPostCreate(jobPost, ce);

        // then
        assertEquals("한국", jpe.getNation());
        assertEquals("서울", jpe.getRegion());
        assertEquals("백엔드", jpe.getPosition());
        assertEquals(1000000, jpe.getRewards());
        assertEquals("java", jpe.getTechnic());
        assertEquals("codeit 하반기 백엔드 개발자 채용", jpe.getTitle());
        assertEquals("상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.", jpe.getContents());
    }

    /**
     *      채용 공고 전체 조회
     * */
    @Test
    void jobPostListAll() {
        // given
        JobPostDTO jobPost1 = new JobPostDTO();
        jobPost1.setNation("한국");
        jobPost1.setRegion("서울");
        jobPost1.setPosition("백엔드");
        jobPost1.setRewards(1000000);
        jobPost1.setTechnic("java");
        jobPost1.setTitle("codeit 하반기 백엔드 개발자 채용");
        jobPost1.setContents("상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.");
        CompanyEntity ce1 = new CompanyEntity();
        ce1.setCompId("codeit");
        JobPostEntity jpe1;
        if(companyRepository.findById(ce1.getCompId()).isPresent())
            jpe1 = JobPostEntity.toSaveEntity(jobPost1, ce1);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        JobPostDTO jobPost2 = new JobPostDTO();
        jobPost2.setNation("한국");
        jobPost2.setRegion("서울");
        jobPost2.setPosition("UI/UX");
        jobPost2.setTechnic("Javascript(ES6)");
        jobPost2.setTitle("삼성SDS 2025 상반기 채용");
        jobPost2.setContents("해당 채용 공고는 하기 이미지와 당사 채용 페이지를 참고하시어 지원 부탁드립니다.");
        CompanyEntity ce2 = new CompanyEntity();
        ce2.setCompId("samsungSDS");
        JobPostEntity jpe2;
        if(companyRepository.findById(ce1.getCompId()).isPresent())
            jpe2 = JobPostEntity.toSaveEntity(jobPost2, ce2);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        jpe1 = jobPostService.jobPostCreate(jobPost1, ce1);
        jpe2 = jobPostService.jobPostCreate(jobPost2, ce2);

        // when
        List<JobPostDTO> list = jobPostService.findList("");

        // then
        assertEquals(2, list.size());
        assertEquals("java", list.get(0).getTechnic());
        assertEquals("Javascript(ES6)", list.get(1).getTechnic());
    }

    /**
     *      채용 공고 검색 조회
     * */
    @Test
    void jobPostListSearch() {
        // given
        JobPostDTO jobPost1 = new JobPostDTO();
        jobPost1.setNation("한국");
        jobPost1.setRegion("서울");
        jobPost1.setPosition("백엔드");
        jobPost1.setRewards(1000000);
        jobPost1.setTechnic("java");
        jobPost1.setTitle("codeit 하반기 백엔드 개발자 채용");
        jobPost1.setContents("상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.");
        CompanyEntity ce1 = new CompanyEntity();
        ce1.setCompId("codeit");
        JobPostEntity jpe1;
        if(companyRepository.findById(ce1.getCompId()).isPresent())
            jpe1 = JobPostEntity.toSaveEntity(jobPost1, ce1);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        JobPostDTO jobPost2 = new JobPostDTO();
        jobPost2.setNation("한국");
        jobPost2.setRegion("서울");
        jobPost2.setPosition("UI/UX");
        jobPost2.setTechnic("Javascript(ES6)");
        jobPost2.setTitle("삼성SDS 2025 상반기 채용");
        jobPost2.setContents("해당 채용 공고는 하기 이미지와 당사 채용 페이지를 참고하시어 지원 부탁드립니다.");
        CompanyEntity ce2 = new CompanyEntity();
        ce2.setCompId("samsungSDS");
        JobPostEntity jpe2;
        if(companyRepository.findById(ce1.getCompId()).isPresent())
            jpe2 = JobPostEntity.toSaveEntity(jobPost2, ce2);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        jpe1 = jobPostService.jobPostCreate(jobPost1, ce1);
        jpe2 = jobPostService.jobPostCreate(jobPost2, ce2);

        String search = "백엔드";
        // when
        List<JobPostDTO> list = jobPostService.findList(search);

        // then
        assertEquals(1, list.size());
        assertEquals("코드잇", list.get(0).getComp_nm());
        assertEquals("java", list.get(0).getTechnic());
    }

    /**
     *  채용 공고 상세조회
     * */
    @Test
    void jobPostDetail(){
        // given
        JobPostDTO jobPost1 = new JobPostDTO();
        jobPost1.setNation("한국");
        jobPost1.setRegion("서울");
        jobPost1.setPosition("백엔드");
        jobPost1.setRewards(1000000);
        jobPost1.setTechnic("java");
        jobPost1.setTitle("codeit 하반기 백엔드 개발자 채용");
        jobPost1.setContents("상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.");
        CompanyEntity ce1 = new CompanyEntity();
        ce1.setCompId("codeit");
        JobPostEntity jpe1;
        if(companyRepository.findById(ce1.getCompId()).isPresent())
            jpe1 = JobPostEntity.toSaveEntity(jobPost1, ce1);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        JobPostDTO jobPost2 = new JobPostDTO();
        jobPost2.setNation("한국");
        jobPost2.setRegion("서울");
        jobPost2.setPosition("프론트엔드");
        jobPost2.setRewards(800000);
        jobPost2.setTechnic("View.js");
        jobPost2.setTitle("codeit 하반기 프론트엔드 개발자 채용");
        jobPost2.setContents("상세한 일정 및 내용은 당사 홈페이지를 확인 하세요.");
        CompanyEntity ce2 = new CompanyEntity();
        ce2.setCompId("codeit");
        JobPostEntity jpe2;
        if(companyRepository.findById(ce2.getCompId()).isPresent())
            jpe2 = JobPostEntity.toSaveEntity(jobPost2, ce2);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        jpe1 = jobPostService.jobPostCreate(jobPost1, ce1);
        jpe2 = jobPostService.jobPostCreate(jobPost2, ce2);

        Long id1 = jpe1.getJpNum();
        Long id2 = jpe2.getJpNum();

        // when
        Map<String, Object> details = jobPostService.findDetails(id1);
        JobPostDTO detail = (JobPostDTO)details.get("detail");
        List<Long> list = (List<Long>)details.get("list");

        // then
        assertEquals("codeit 하반기 백엔드 개발자 채용", detail.getTitle());
        assertEquals(1, list.size());

    }

    /**
     *  채용 공고 업데이트
     * */
    @Test
    void jobPostUpdate() {
        // given
        JobPostDTO existingJobPostDTO = new JobPostDTO();
        existingJobPostDTO.setNation("한국");
        existingJobPostDTO.setRegion("서울");
        existingJobPostDTO.setPosition("UI/UX");
        existingJobPostDTO.setTechnic("Javascript(ES6)");
        existingJobPostDTO.setTitle("삼성SDS 2025 상반기 채용");
        existingJobPostDTO.setContents("해당 채용 공고는 하기 이미지와 당사 채용 페이지를 참고하시어 지원 부탁드립니다.");

        CompanyEntity ce = new CompanyEntity();
        ce.setCompId("samsungSDS");

        JobPostEntity jpe;
        if(companyRepository.findById(ce.getCompId()).isPresent())
            jpe = JobPostEntity.toSaveEntity(existingJobPostDTO, ce);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        jpe = jobPostRepository.save(jpe);

        JobPostDTO dto = new JobPostDTO();
        dto.setPosition("프론트엔드");
        dto.setTechnic("React");
        dto.setContents("해당 채용공고는 당사 채용 홈페이지에서 지원 가능합니다.");

        // when
        JobPostEntity updatedJobPost = jobPostService.update(jpe.getJpNum(), dto);

        // then
        assertEquals("프론트엔드", updatedJobPost.getPosition());
        assertEquals("React", updatedJobPost.getTechnic());
        assertEquals("해당 채용공고는 당사 채용 홈페이지에서 지원 가능합니다.", updatedJobPost.getContents());

    }

    /**
     *  채용 공고 삭제
     * */
    @Test
    void jobPostDelete() {
        // given
        JobPostDTO existingJobPostDTO = new JobPostDTO();
        existingJobPostDTO.setNation("한국");
        existingJobPostDTO.setRegion("서울");
        existingJobPostDTO.setPosition("UI/UX");
        existingJobPostDTO.setTechnic("Javascript(ES6)");
        existingJobPostDTO.setTitle("삼성SDS 2025 상반기 채용");
        existingJobPostDTO.setContents("해당 채용 공고는 하기 이미지와 당사 채용 페이지를 참고하시어 지원 부탁드립니다.");

        CompanyEntity ce = new CompanyEntity();
        ce.setCompId("samsungSDS");

        JobPostEntity jpe;
        if(companyRepository.findById(ce.getCompId()).isPresent())
            jpe = JobPostEntity.toSaveEntity(existingJobPostDTO, ce);
        else
            throw new RuntimeException("존재하지 않는 아이디입니다.");

        jpe = jobPostRepository.save(jpe);
        Long id = jpe.getJpNum();

        // when
        jobPostService.delete(id, ce);

        // then
        assertFalse(jobPostRepository.findById(id).isPresent());
    }

}