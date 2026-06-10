package com.jpmc.midascore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Balance {

    @Id
    private Long userId;
    private Double balance;

    public Balance() {}

    public Balance(Long userId, Double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getBalance() {
        return balance;
    }
}
