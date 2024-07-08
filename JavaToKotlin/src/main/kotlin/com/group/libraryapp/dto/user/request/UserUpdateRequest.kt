package com.group.libraryapp.dto.user.request

data class UserUpdateRequest(
    val id: Long,
    val name: String
) {

    companion object {
        fun from(id: Long, name: String): UserUpdateRequest {
            return UserUpdateRequest(id!!, name)
        }
    }
}