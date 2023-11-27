package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.model.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito,Long> {
}
