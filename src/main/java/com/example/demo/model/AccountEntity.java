package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @Min(value = 0)
    private BigDecimal money;

    public void addMoney(BigDecimal amount) {
        this.money = this.money.add(amount);
    }

    public void subtractMoney(BigDecimal amount) {
        this.money = this.money.subtract(amount);
    }
}
