package com.example.demo.controller;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DepositRequest {

    private Long id;
    private BigDecimal money;
}
