package com.wanted.siplanet.jobpost.repository;

import com.wanted.siplanet.jobpost.entity.JobRegisterEntity;
import com.wanted.siplanet.jobpost.entity.JobRegisterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRegisterRepository extends JpaRepository<JobRegisterEntity, JobRegisterId> {

}
