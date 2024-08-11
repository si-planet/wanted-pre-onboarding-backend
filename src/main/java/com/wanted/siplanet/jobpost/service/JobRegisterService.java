package com.wanted.siplanet.jobpost.service;

import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import com.wanted.siplanet.jobpost.entity.JobRegisterEntity;
import com.wanted.siplanet.jobpost.entity.JobRegisterId;
import com.wanted.siplanet.jobpost.entity.UserEntity;
import com.wanted.siplanet.jobpost.repository.JobPostRepository;
import com.wanted.siplanet.jobpost.repository.JobRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobRegisterService {

    private final JobPostRepository jobPostRepository;
    private final JobRegisterRepository jobRegisterRepository;

    public JobRegisterEntity register(Long jpNum, UserEntity ue) {
        JobPostEntity jobPost = jobPostRepository.findById(jpNum)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 채용 공고 입니다."));

        // 복합키 생성
        JobRegisterId jobRegisterId = new JobRegisterId(jpNum, ue.getUserId());

        JobRegisterEntity jre = new JobRegisterEntity();
        jre.setId(jobRegisterId);
        jre.setJp(jobPost);
        jre.setUser(ue);

        return jobRegisterRepository.save(jre);
    }
}
