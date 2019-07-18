package com.tostringtech.refp.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tostringtech.refp.application.model.Subtema;

public interface TemaRepository extends JpaRepository<Subtema, Long> {

}
