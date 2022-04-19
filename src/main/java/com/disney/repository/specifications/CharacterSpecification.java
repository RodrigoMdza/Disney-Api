package com.disney.repository.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import com.disney.dto.CharacterFiltersDTO;
import com.disney.entity.CharacterEntity;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CharacterSpecification {
    
    /*
    public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDTO) {
        return (root ,query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add (
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + filtersDTO.getName().toLowerCase() + "%"
                    )
                );
            }
    
            if (StringUtils.hasLength(filtersDTO.getAge())) {

            }
        };
    }
    */
}