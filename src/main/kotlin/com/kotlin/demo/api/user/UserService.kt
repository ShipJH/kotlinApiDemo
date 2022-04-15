package com.kotlin.demo.api.user

import com.kotlin.demo.api.user.model.UserData
import com.kotlin.demo.api.user.model.UserDataClassSample
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(@Autowired private val userRepository : UserRepository,
                  @Autowired private val userDataClassRepository : UserDataClassRepository) {

    fun oneUser(id: Long): UserData.UserResponse {
        val user = userRepository.findById(id).orElse(null)
        return if (user != null) {
            UserData.UserResponse(user.id,user.username,user.age)
        } else {
            // throw new DataNotFoundException();
            UserData.UserResponse()
        }
    }

    @Transactional
    fun registUser(user: UserData.UserRequest) {
        userRepository.save(user.registUserEntity())
    }

    fun allUser(): List<UserData.UserResponse> {
        val response = mutableListOf<UserData.UserResponse>()
        userRepository.findAll().forEach {data ->
            response += UserData.UserResponse(data.id, data.username, data.age)
        }
        return response
    }

    @Transactional
    fun updateUser(user: UserData.UserRequest) {
        userRepository.save(user.updateUserEntity())
    }


    @Transactional
    fun registUserDataClass(user: UserDataClassSample.UserDataClassRequest) {
        userDataClassRepository.save(user)
    }

    fun allUserDataClass(): List<UserDataClassSample.UserDataClassRequest> {
        return userDataClassRepository.findAll().toList()
    }


}
