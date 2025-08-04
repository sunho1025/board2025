package com.example.webPrograming.repository;

import com.example.webPrograming.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepsitory extends JpaRepository<Sample, Long> {
}
