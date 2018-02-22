package com.jpuggian.sample.resource

import com.jpuggian.sample.domain.Fruit
import com.jpuggian.sample.service.FruitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/fruits")
class FruitController {

    @Autowired
    FruitService fruitService

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Fruit> getFruits() {

        try{
            return fruitService.getFruits()
        } catch (Exception e){
            e.printStackTrace()
            return []
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Fruit getFruitById(@PathVariable Long id) {
        try{
            return fruitService.getFruitById(id)
        } catch (Exception e){
            e.printStackTrace()
            return null
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity create(@RequestBody Fruit fruit) {
        try {
            Fruit savedFruit = fruitService.create(fruit)
            return new ResponseEntity<Fruit>(savedFruit, HttpStatus.CREATED)
        } catch (Exception e){
            e.printStackTrace()
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    ResponseEntity update(@PathVariable Long id, @RequestBody Fruit fruit) {
        try {
            Fruit updatedFruit = fruitService.update(id, fruit)
            return new ResponseEntity<Fruit>(updatedFruit, HttpStatus.OK)
        } catch (Exception e){
            e.printStackTrace()
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    ResponseEntity delete(@PathVariable Long id) {
        try {
            fruitService.delete(id)
            return ResponseEntity.ok().body(null)
        } catch (Exception e){
            e.printStackTrace()
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }

}
