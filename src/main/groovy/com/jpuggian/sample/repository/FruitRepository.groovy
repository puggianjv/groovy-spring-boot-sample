package com.jpuggian.sample.repository

import com.jpuggian.sample.domain.Fruit
import org.springframework.data.repository.CrudRepository

interface FruitRepository extends CrudRepository<Fruit, Long> {

    Fruit findById(Long id)

    Fruit save(Fruit fruit)

    void delete(Fruit fruit)

}