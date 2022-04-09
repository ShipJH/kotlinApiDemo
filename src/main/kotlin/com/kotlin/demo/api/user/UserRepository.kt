package com.kotlin.demo.api.user

import com.kotlin.demo.api.user.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
}
