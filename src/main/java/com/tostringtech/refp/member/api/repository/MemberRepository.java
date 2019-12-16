package com.tostringtech.refp.member.api.repository;

import com.tostringtech.refp.application.models.Membro;
import com.tostringtech.refp.member.api.repository.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Membro,Long>,MemberRepositoryCustom {
}
