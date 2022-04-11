package com.kotlin.demo.api.user.model

import com.kotlin.demo.annotation.NoArg

class UserData {

    enum class Gender {
        MAN, WOMAN
    }

    data class UserRequest(val id : Long, val name : String, val age: Int) {

        fun registUserEntity(): User {
            return User(name = name, age = age)
        }
    }

    data class UserResponse(val id: Long, val name: String, val age : Int) {
        constructor() : this(-1, "", -1)
        constructor(name : String, age : Int) : this(-1, name, age)
    }

}