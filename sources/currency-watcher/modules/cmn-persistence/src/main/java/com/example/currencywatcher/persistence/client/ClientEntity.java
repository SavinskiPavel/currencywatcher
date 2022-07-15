package com.example.currencywatcher.persistence.client;

import com.example.currencywatcher.persistence.cryptocurrency.CryptocurrencyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "fixed_cryptocurrency_price")
    private String fixedCryptocurrencyPrice;

    @CreationTimestamp
    @Column(name = "subscription_ts", updatable = false)
    private LocalDateTime subscriptionTs;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<CryptocurrencyEntity> cryptocurrencies = new ArrayList<>();
}
