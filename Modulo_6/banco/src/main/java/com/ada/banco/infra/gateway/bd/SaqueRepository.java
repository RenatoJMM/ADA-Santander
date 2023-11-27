package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.model.Saque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaqueRepository extends JpaRepository<Saque,Long> {
}
