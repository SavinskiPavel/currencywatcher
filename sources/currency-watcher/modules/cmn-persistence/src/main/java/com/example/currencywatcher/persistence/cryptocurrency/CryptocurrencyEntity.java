package com.example.currencywatcher.persistence.cryptocurrency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cryptocurrency")
public class CryptocurrencyEntity {

    @Id
    private String id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "price_usd")
    private String priceUsd;
}
