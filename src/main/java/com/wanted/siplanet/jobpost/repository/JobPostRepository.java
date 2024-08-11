package com.wanted.siplanet.jobpost.repository;

import com.wanted.siplanet.jobpost.entity.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Long> {
    // select comp_id from jobpost where comp_id = ? and jp_num != ?
    @Query(value = "select j.jpNum from JobPostEntity j where j.ce.compId = :compId and j.jpNum != :jpNum")
    List<Long> findByComp(@Param("compId") String compId, @Param("jpNum") Long jpNum);

    @Query("SELECT j FROM JobPostEntity j WHERE " +
            "j.nation LIKE %:keyword% OR " +
            "j.region LIKE %:keyword% OR " +
            "j.position LIKE %:keyword% OR " +
            "j.technic LIKE %:keyword% OR " +
            "j.title LIKE %:keyword% OR " +
            "j.contents LIKE %:keyword% OR " +
            "j.ce.compId LIKE %:keyword%")
    List<JobPostEntity> findByKeywordContaining(@Param("keyword") String search);

}
