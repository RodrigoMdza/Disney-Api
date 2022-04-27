package com.disney.repository;

import java.util.List;
import com.disney.entity.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long>{

    List<CharacterEntity> findAll(Specification<CharacterEntity> spec);

}
    
