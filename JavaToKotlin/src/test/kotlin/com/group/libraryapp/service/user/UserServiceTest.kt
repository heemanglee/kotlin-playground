package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
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
            listOf(
                User("A", 20, Collections.emptyList(), null),
                User("B", null, Collections.emptyList(), null)
            )
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
        val savedUser = userRepository.save(
            User(
                "이희망",
                25,
                Collections.emptyList(),
                null
            )
        )
        // Kotlin: Long?, Java: long이므로 null이 아님을 단언(!!)
        val request = UserUpdateRequest(savedUser.id!!, "이희망")

        // when
        userService.updateUserName(request)

        // then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("이희망")
    }

    @Test
    fun deleteUserTest() {
        // given
        userRepository.save(User("이희망", 25, Collections.emptyList(), null))

        // when
        userService.deleteUser("이희망")

        // then
        assertThat(userRepository.findAll()).hasSize(0)
    }

    @Test
    @DisplayName("대출 기록이 없는 사용자를 조회할 수 있다.")
    fun getUserLoanHistoryTest1() {
        // given
        userRepository.save(User("A"))

        // when
        val results = userService.getUserLoanHistories()

        // then
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("A")
        assertThat(results[0].books).isEmpty()
    }

    @Test
    @DisplayName("대출 기록이 있는 사용자를 조회할 수 있다.")
    fun getUserLoanHistoryTest2() {
        // given
        var savedUser = userRepository.save(User("A"))
        userLoanHistoryRepository.saveAll(
            listOf(
                UserLoanHistory.fixture(savedUser, "bookA"),
                UserLoanHistory.fixture(savedUser, "bookB"),
                UserLoanHistory.fixture(savedUser, "bookC", UserLoanStatus.RETURNED),
            )
        )

        println("---------")
        // when
        var results = userService.getUserLoanHistories()

        // then
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("A")
        assertThat(results[0].books).hasSize(3)
        assertThat(results[0].books).extracting("name")
            .containsExactlyInAnyOrder("bookA", "bookB", "bookC")
        assertThat(results[0].books).extracting("isReturn")
            .containsExactlyInAnyOrder(false, false, true)
    }

}