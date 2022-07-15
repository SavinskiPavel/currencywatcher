package com.example.currencywatcher.persistence.cryptocurrency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<CryptocurrencyEntity, String> {

    Optional<CryptocurrencyEntity> findBySymbol(String symbol);
}
