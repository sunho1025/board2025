package com.example.webPrograming.repository;

import com.example.webPrograming.domain.Sample;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.*;


public class SampleSpecs {
    public static Specification<Sample> search(Map<String, Object> filter){
        return(root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            filter.forEach ((key, value) -> {
                switch (key) {
                    case "title":
                        predicates.add(builder.equal(root.get(key).as(String.class), value));
                }
            });
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
