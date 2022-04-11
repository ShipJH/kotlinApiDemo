package com.kotlin.demo

import com.kotlin.demo.api.user.model.UserData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Unit {

    @Test
    fun listAddObject() {
        //given
        val response = mutableListOf<UserData.UserResponse>()

        //when
        response += UserData.UserResponse(name = "BAE_TEST", age = 10)
        response += UserData.UserResponse(name = "KIM_TEST", age = 77)

        //then
        assertEquals(2, response.size)
    }


//    @Test
//    fun listAddObject() {
//        //given
//        val response = mutableListOf<UserData.UserResponse>()
//
//        //when
//        response += UserData.UserResponse(1,"BAE_TEST", 77)
//        response += UserData.UserResponse(2,"KIM_TEST", 12)
//
//        //then
//        assertEquals(2, response.size)
//    }


}