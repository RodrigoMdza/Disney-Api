package com.disney.repository.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import com.disney.dto.MovieFiltersDTO;
import com.disney.entity.GenderEntity;
import com.disney.entity.MovieEntity;
import com.disney.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MovieSpecification {

    @Autowired
    MovieService movieService;

    public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(  
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );

            }
            if (filtersDTO.getGender() != null) {
                Join<GenderEntity, MovieEntity> join = root.join("gender", JoinType.INNER);
                Expression<String> genderId = join.get("id");
                predicates.add(genderId.in(filtersDTO.getGender()));
            }

            query.distinct(true);

            String orderByField = "creationDate";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
    
}
