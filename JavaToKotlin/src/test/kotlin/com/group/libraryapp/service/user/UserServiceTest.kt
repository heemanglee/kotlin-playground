package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @AfterEach
    fun afterEach() {
        userRepository.deleteAll()
    }

    @Test
    fun saveUserTest() {
        // given
        val request = UserCreateRequest("이희망", null)

        // when
        userService.saveUser(request)

        // then
        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("이희망")
        /**
         * 코틀린은 자바 코드에 대해서 필드의 null 가능 여부를 알 수가 없다
         * 따라서 @Nullable 명시를 하지 않으면 에러가 발생한다.
         * java.lang.NullPointerException: results[0].age must not be null
         */
        assertThat(results[0].age).isNull()
    }

    @Test
    fun getUsersTest() {
        // given
        userRepository.saveAll(
            listOf(User("A", 20), User("B", null))
        )

        // when
        val results = userService.getUsers()

        // then
        assertThat(results).hasSize(2)
        assertThat(results).extracting("name").containsExactlyInAnyOrder("A", "B")
        assertThat(results).extracting("age").containsExactlyInAnyOrder(20, null)
    }

    @Test
    fun updateUserNameTest() {
        // given
        val savedUser = userRepository.save(User("이희망", 25))
        val request = UserUpdateRequest(savedUser.id, "이희망")

        // when
        userService.updateUserName(request)

        // then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("이희망")
    }

    @Test
    fun deleteUserTest() {
        // given
        userRepository.save(User("이희망", 25))

        // when
        userService.deleteUser("이희망")

        // then
        assertThat(userRepository.findAll()).hasSize(0)
    }

}