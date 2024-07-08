package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User

data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int?
) {

    // 부생성자 보단 정적 팩토리 메서드를 적용한다.
    //
    companion object {
        fun of(user: User): UserResponse {
            return UserResponse(
                user.id!!, user.name, user.age
            )
        }
    }
}