package com.kotlin.demo.api.user

import com.kotlin.demo.api.user.model.UserDataClassSample
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDataClassRepository : CrudRepository<UserDataClassSample.UserDataClassRequest, Long> {

}
