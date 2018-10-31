package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @Column
    private Long id;
    @Column
    private BigDecimal money;
}
