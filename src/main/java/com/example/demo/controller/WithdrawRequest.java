package com.example.demo.controller;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawRequest {

    private Long id;
    private BigDecimal money;
}
