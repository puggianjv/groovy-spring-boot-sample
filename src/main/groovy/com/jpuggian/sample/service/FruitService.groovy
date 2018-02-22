package com.jpuggian.sample.service

import com.jpuggian.sample.domain.Fruit
import com.jpuggian.sample.repository.FruitRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Transactional
@Service
class FruitService {

    @Autowired
    FruitRepository fnRepository

    Iterable<Fruit> getFruits() {

        fnRepository.findAll()

    }

    Fruit getFruitById(long id) {

        fnRepository.findById(id)

    }

    Fruit create(Fruit fruit) {

        fnRepository.save(fruit)

    }

    Fruit update(long id, Fruit updatedFruit) {

        Fruit fruitToUpdate = fnRepository.findById(id)

        fruitToUpdate.name = updatedFruit.name
        fruitToUpdate.description = updatedFruit.description

        fnRepository.save(fruitToUpdate)

    }

    void delete (Long id) {

        Fruit fruit = fnRepository.findById(id)

        fnRepository.delete(fruit)

    }
}
