package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {


}
