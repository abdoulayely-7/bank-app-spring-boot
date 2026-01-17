package org.example.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
