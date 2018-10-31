package com.example.demo.controller;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {

    private Long from;
    private Long to;
    private BigDecimal money;
}
