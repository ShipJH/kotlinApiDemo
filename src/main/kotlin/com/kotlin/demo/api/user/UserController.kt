package com.kotlin.demo.api.user

import com.kotlin.demo.api.user.model.User
import com.kotlin.demo.api.user.model.UserData
import com.kotlin.demo.api.user.model.UserDataClassSample
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(@Autowired private val userService : UserService) {


    @GetMapping("/user/{id}")
    fun oneUser(@PathVariable("id") id: Long ): UserData.UserResponse {
        return userService.oneUser(id);
    }

    @GetMapping("/user")
    fun allUser(): List<UserData.UserResponse> {
        return userService.allUser()
    }

    @PostMapping("/user")
    fun registUser(@RequestBody user : UserData.UserRequest) {
        println("registUser, request user: $user")
        userService.registUser(user)
    }

    @PutMapping("/user")
    fun updateUser(@RequestBody user : UserData.UserRequest): Unit {
        print("updateUser, request user : $user")
        userService.updateUser(user)
    }



    @PostMapping("/userData")
    fun registUserDataClass(@RequestBody user : UserDataClassSample.UserDataClassRequest) {
        userService.registUserDataClass(user)
    }

    @GetMapping("/userData")
    fun allUser2(): List<UserDataClassSample.UserDataClassRequest> {
        return userService.allUserDataClass()
    }

}