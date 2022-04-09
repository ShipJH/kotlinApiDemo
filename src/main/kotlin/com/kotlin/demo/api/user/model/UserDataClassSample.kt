package com.kotlin.demo.api.user.model

import javax.persistence.*

class UserDataClassSample {

    enum class Gender {
        MAN, WOMAN
    }

    @Entity
    @Table(name = "userDataClassTbl")
    data class UserDataClassRequest(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id : Long = 0,
        @Column(name = "username") val name : String,
        @Column(name = "age") val age: Int)

}