package com.wanted.siplanet.jobpost.repository;

import com.wanted.siplanet.jobpost.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, String> {
}
