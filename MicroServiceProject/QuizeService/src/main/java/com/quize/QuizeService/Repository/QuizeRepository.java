package com.quize.QuizeService.Repository;

import com.quize.QuizeService.Entity.Quize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizeRepository extends JpaRepository<Quize,Long> {

}
