package com.wanted.siplanet.jobpost.contorller;

import com.wanted.siplanet.jobpost.entity.UserEntity;
import com.wanted.siplanet.jobpost.service.JobRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class JobRegisterController {

    private final JobRegisterService jobRegisterService;

    /**
     *  채용 공고 지원
     * */
    @PostMapping("/jobregister")
    public String jobRegister(@RequestParam Long jpNum, @RequestParam UserEntity ue) {

        jobRegisterService.register(jpNum, ue);

        return "redirect:/jobpostdetails/" + jpNum;

    }
}
