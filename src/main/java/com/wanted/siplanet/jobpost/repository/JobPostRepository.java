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

    @Query(value = "SELECT j.* FROM jobpost j " +
                    "JOIN company c ON j.comp_id = c.comp_id " +
                    "WHERE MATCH(j.nation, j.region, j.position, j.technic, j.title, j.contents) " +
                    "AGAINST (:keyword IN BOOLEAN MODE) " +
                    "OR MATCH(c.comp_nm) AGAINST (:keyword IN BOOLEAN MODE)", nativeQuery = true)
    List<JobPostEntity> searchByKeyword(@Param("keyword") String keyword);

}
