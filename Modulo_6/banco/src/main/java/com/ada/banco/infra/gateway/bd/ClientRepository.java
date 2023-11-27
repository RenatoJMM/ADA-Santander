package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByCpf(String cpf);
}
