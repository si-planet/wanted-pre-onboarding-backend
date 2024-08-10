package com.wanted.siplanet.jobpost.contorller;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import com.wanted.siplanet.jobpost.entity.CompanyEntity;
import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import com.wanted.siplanet.jobpost.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    /**
     *  채용 공고 작성
     */
    @PostMapping("/jobpost/post")
    public String jobPostCreate (@RequestBody JobPostDTO dto, @RequestBody CompanyEntity ce) {
        JobPostEntity jobPostEntity = jobPostService.jobPostCreate(dto, ce);
        return "redirect:/jobpost/detail/"+jobPostEntity.getJpNum();
    }

    /**
     *  채용 공고 목록 확인 + 검색
     */
    @GetMapping("/jobpost/all")
    @ResponseBody
    public Map<String, Object> jobPostList (@RequestParam String search) {
        Map<String, Object> result = new HashMap<>();

        List<JobPostDTO> list = jobPostService.findList(search);
        result.put("list", list);

        return result;
    }

    /**
     *  채용 공고 상세
     */
    @GetMapping("/jobpost/detail/{id}")
    @ResponseBody
    public Object jobPostDetail (@PathVariable Long id) {
        return jobPostService.findDetails(id);
    }

    /**
     *  채용 공고 수정
     */
    @PutMapping("/jobpost/detail/{id}")
    public String jobPostUpdate (@PathVariable Long id, @RequestBody JobPostDTO dto) {
        jobPostService.modify(id, dto);

        return "redirect:/jobpost/detail/" +  id;
    }


}
