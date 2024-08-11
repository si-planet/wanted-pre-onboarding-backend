package com.wanted.siplanet.jobpost.service;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import com.wanted.siplanet.jobpost.entity.CompanyEntity;
import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import com.wanted.siplanet.jobpost.entity.JobRegisterEntity;
import com.wanted.siplanet.jobpost.entity.UserEntity;
import com.wanted.siplanet.jobpost.repository.CompanyRepository;
import com.wanted.siplanet.jobpost.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class JobRegisterServiceTest {

    @Autowired private JobRegisterService jobRegisterService;
    @Autowired private CompanyRepository companyRepository;
    @Autowired private JobPostService jobPostService;
    @Autowired private UsersRepository usersRepository;

    @Test
    void register() {
        // given
        UserEntity ue = new UserEntity();
        ue.setUserId("user001");

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
        jpe = jobPostService.jobPostCreate(jobPost, ce);

        // when
        JobRegisterEntity register;
        if (usersRepository.findById(ue.getUserId()).isPresent()){
            register = jobRegisterService.register(jpe.getJpNum(), ue);
        } else {
            throw new RuntimeException("존재하지 않는 유저입니다.");
        }

        // then
        assertEquals(jpe.getJpNum(), register.getJp().getJpNum());
        assertEquals("user001", register.getUser().getUserId());
    }
}