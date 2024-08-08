package com.wanted.siplanet.jobpost.contorller;

import com.wanted.siplanet.jobpost.dto.JobPostDTO;
import com.wanted.siplanet.jobpost.entity.CompanyEntity;
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
    @ResponseBody
    public String jobPostCreate (@RequestBody JobPostDTO dto, @RequestBody CompanyEntity ce) {
        jobPostService.jobPostCreate(dto, ce);
        return "redirect:/jobpost/get";
    }

    /**
     *  채용 공고 목록 확인
     */
    @GetMapping("/jobpost/get")
    @ResponseBody
    public Map<String, Object> jobPostList () {
        Map<String, Object> result = new HashMap<>();

        List<JobPostDTO> list = jobPostService.findAll();
        result.put("list", list);

        return result;
    }

    /**
     *  채용 공고 상세
     */
    @GetMapping("/jobpost/get/{id}")
    @ResponseBody
    public Object jobPostDetail (@PathVariable Long id) {
        return jobPostService.findDetails(id);
    }

    /**
     *  채용 공고 검색
     */
    @GetMapping("/jobpost/search")
    @ResponseBody
    public List<JobPostDTO> jobPostSearch (@RequestParam String keyword) {
        return jobPostService.search(keyword);
    }


}
