package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.BookHistoryResponse
import com.group.libraryapp.dto.user.response.UserLoanHistoryResponse
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.util.fail
import com.group.libraryapp.util.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val user = User(request.name, request.age, Collections.emptyList(), null)
        userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> {
        return userRepository.findAll()
            .stream()
            /**
             * Java : map(UserResponse::new)
             * Kotlin : map(::UserResponse)
             */
            .map { user -> UserResponse.of(user) }
            .toList()
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        // Java + JPA -> findById()는 Optional을 반환한다.
//        val user = userRepository.findById(request.id)
//            .orElseThrow(::IllegalArgumentException)

        // Kotlin + JPA -> findById() 대신에 확장함수를 구현한 CrudRepositoryExtension 사용한다.
//        val user = userRepository.findByIdOrNull(request.id) ?: fail()

        // CrudRepositoryExtension.findByIdOrNull()의 확장함수인 findByIdOrThrow()
        val user = userRepository.findByIdOrThrow(request.id)
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name) ?: fail()
        userRepository.delete(user)
    }

    @Transactional(readOnly = true)
    fun getUserLoanHistories(): List<UserLoanHistoryResponse> {
        return userRepository.findAllWithHistories()
            .map(UserLoanHistoryResponse::of)
    }

}