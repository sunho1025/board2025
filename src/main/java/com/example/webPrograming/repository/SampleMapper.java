package com.example.webPrograming.repository;

import com.example.webPrograming.domain.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.*;

@Mapper
public interface SampleMapper {
    List<Sample> findAll();
    Sample findById(Long id);
    List<Sample> findAllByTitle(String title, RowBounds rowBounds);
}
