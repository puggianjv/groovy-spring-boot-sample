package com.jpuggian.sample.domain

import javax.persistence.*

@Entity
class Fruit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id

    @Column(nullable = false, length = 255, unique = true)
    String name

    @Column(length = 255)
    String description


}
