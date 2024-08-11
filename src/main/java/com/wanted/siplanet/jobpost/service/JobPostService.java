package com.wanted.siplanet.jobpost.service;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import com.wanted.siplanet.jobpost.entity.CompanyEntity;
import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import com.wanted.siplanet.jobpost.repository.CompanyRepository;
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
    private final CompanyRepository companyRepository;

    public JobPostEntity jobPostCreate(JobPostDTO dto, CompanyEntity ce) {
        JobPostEntity jobPostEntity = JobPostEntity.toSaveEntity(dto, ce);
        return jobPostRepository.save(jobPostEntity);
    }


    public List<JobPostDTO> findList(String search) {
        List<JobPostEntity> eList;
        if(search==null || search.trim().isEmpty())
            eList = jobPostRepository.findAll();
        else
            eList = jobPostRepository.findByKeywordContaining(search);

        List<JobPostDTO> dtoList = new ArrayList<>();

        for(JobPostEntity jpe : eList){
            dtoList.add(findById(jpe.getJpNum()));
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
            JobPostDTO dto = JobPostDTO.toJobPostDTO(optionalJpe.get());

            Optional<CompanyEntity> byId = companyRepository.findById(optionalJpe.get().getCe().getCompId());
            dto.setComp_nm(byId.get().getCompNm());

            return dto;
        } else {
            return null;
        }
    }

    private List<Long> findByComp(Long jpNum) {
        List<Long> jobPostIdList = new ArrayList<>();

        String compId = jobPostRepository.findById(jpNum).get().getCe().getCompId();
        return jobPostRepository.findByComp(compId, jpNum);
    }

    public JobPostEntity update(Long jpNum, JobPostDTO dto) {
        JobPostEntity jpe = jobPostRepository.findById(jpNum).get();

        jpe.setNation(dto.getNation());
        jpe.setRegion(dto.getRegion());
        jpe.setPosition(dto.getPosition());
        jpe.setRewards(dto.getRewards());
        jpe.setTechnic(dto.getTechnic());
        jpe.setTitle(dto.getTitle());
        jpe.setContents(dto.getContents());

        return jobPostRepository.save(jpe);
    }

    public void delete(Long jpNum, CompanyEntity ce) {
        Optional<JobPostEntity> byId = jobPostRepository.findById(jpNum);
        if(byId.isPresent()){
            String contentsId = byId.get().getCe().getCompId();
            if(contentsId.equals(ce.getCompId()))
                jobPostRepository.delete(byId.get());
            else
                throw new RuntimeException("해당 게시물에 삭제 권한이 없습니다.");
        } else {
            throw new RuntimeException("해당 게시물은 존재하지 않습니다.");
        }
    }
}
