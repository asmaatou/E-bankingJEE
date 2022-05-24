package org.sid.ebankingbackend.repositories;

import org.sid.ebankingbackend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRespository extends JpaRepository<AccountOperation,Long> {
    public List<AccountOperation> findByAccountId(String accountId);
}
