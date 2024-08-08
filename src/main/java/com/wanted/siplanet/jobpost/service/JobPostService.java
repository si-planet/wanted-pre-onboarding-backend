package com.wanted.siplanet.jobpost.service;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import com.wanted.siplanet.jobpost.entity.CompanyEntity;
import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import com.wanted.siplanet.jobpost.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public JobPostEntity jobPostCreate(JobPostDTO dto, CompanyEntity ce) {
        JobPostEntity jobPostEntity = JobPostEntity.toSaveEntity(dto, ce);
        return jobPostRepository.save(jobPostEntity);
    }


    public List<JobPostDTO> findAll() {
        List<JobPostEntity> eList = jobPostRepository.findAll();
        List<JobPostDTO> dtoList = new ArrayList<>();

        for(JobPostEntity jpe : eList){
            dtoList.add(JobPostDTO.toJobPostDTOAll(jpe));
        }

        return dtoList;
    }

    public Map<String, Object> findDetails(Long jpNum) {
        Map<String, Object> result = new HashMap<>();

        JobPostDTO dto = findById(jpNum);
        List<Long> postList = findByComp(jpNum);

        result.put("detail", dto);
        result.put("list", postList);

        return result;
    }

    private JobPostDTO findById(Long jpNum) {
        Optional<JobPostEntity> optionalJpe = jobPostRepository.findById(jpNum);
        if(optionalJpe.isPresent()){
            return JobPostDTO.toJobPostDTO(optionalJpe.get());
        } else {
            return null;
        }
    }

    private List<Long> findByComp(Long jpNum) {
        List<Long> jobPostIdList = new ArrayList<>();

        String compId = jobPostRepository.findById(jpNum).get().getCe().getCompId();
        return jobPostRepository.findByComp(compId, jpNum);
    }


    public List<JobPostDTO> search(String keyword) {
        List<JobPostEntity> entityList = jobPostRepository.searchByKeyword(keyword);
        List<JobPostDTO> dtoList = new ArrayList<>();

        for(JobPostEntity jpe : entityList){
            dtoList.add(JobPostDTO.toJobPostDTO(jpe));
        }

        return dtoList;
    }
}
