package com.userFront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userFront.domain.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);
}