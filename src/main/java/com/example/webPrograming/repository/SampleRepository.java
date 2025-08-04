package com.example.webPrograming.repository;

import com.example.webPrograming.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SampleRepository extends JpaRepository<Sample, Long>, JpaSpecificationExecutor<Sample> {
    List<Sample> findByTitle(String title);
    List<Sample> findByTitleLike(String title);
}
