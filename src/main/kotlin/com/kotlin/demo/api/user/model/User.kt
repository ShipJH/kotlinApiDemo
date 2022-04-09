package com.kotlin.demo.api.user.model

import javax.persistence.*

@Entity
@Table(name = "userTbl")
class User() {

    constructor(id: Long, name: String, age: Int) : this() {
        id.also {  this.id = id }
        name.also { this.username = name }
        age.also { this.age = age }
    }


    constructor(name: String, age: Int) : this() {
        name.also { this.username = name }
        age.also { this.age = age }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = false)
    var id : Long = 0

    @Column(name = "userName")
    var username : String = ""

    @Column(name = "age")
    var age : Int = 0

}