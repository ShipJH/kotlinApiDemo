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
    fun registUser(userData: UserData.UserRequest) {
        val user = userData.registUserEntity()
        userRepository.save(user)
    }

    fun allUser(): List<UserData.UserResponse> {
        val response = mutableListOf<UserData.UserResponse>()
        userRepository.findAll().forEach { l ->
            response += UserData.UserResponse(l.id, l.username, l.age)
        }
        return response
    }

    @Transactional
    fun registUserDataClass(user: UserDataClassSample.UserDataClassRequest) {
        userDataClassRepository.save(user)
    }

    fun allUserDataClass(): List<UserDataClassSample.UserDataClassRequest> {
        return userDataClassRepository.findAll().toList()
    }

}
