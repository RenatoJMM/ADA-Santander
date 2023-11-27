package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByAgencia(Long agencia);
}
