package com.davidhorstman.piggybank.repositories;

import com.davidhorstman.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long> {
}
