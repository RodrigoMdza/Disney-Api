package com.disney.repository.specifications;

import java.util.ArrayList;
import java.util.List;

import com.disney.dto.CharacterFiltersDTO;
import com.disney.entity.CharacterEntity;
import com.disney.entity.MovieEntity;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

@Component
public class CharacterSpecification {
    
    public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) { 
                predicates.add( 
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );

            }
            if (filtersDTO.getAge() != null) { 
                predicates.add(  
                        criteriaBuilder.equal(root.get("age"), filtersDTO.getAge())
                );

            }

            if (!CollectionUtils.isEmpty(filtersDTO.getMoviesId())) {
                Join<CharacterEntity, MovieEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> movieId = join.get("id");
                predicates.add(movieId.in(filtersDTO.getMoviesId()));
            }

            query.distinct(true);

            String orderByField = "name";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}