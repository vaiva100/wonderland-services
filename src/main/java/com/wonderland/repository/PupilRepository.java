package com.wonderland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wonderland.model.PupilInformation;

@Repository
public interface PupilRepository  extends JpaRepository<PupilInformation,Long>{

}
