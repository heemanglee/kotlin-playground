package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun afterEach() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    fun saveBookTest() {
        // given
        val request = BookRequest("엘리스", "COMPUTER")

        // when
        bookService.saveBook(request)

        // then
        val results = bookRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("엘리스")
        assertThat(results[0].type).isEqualTo("COMPUTER")
    }

    @Test
    fun loanBookTest() {
        // given
        bookRepository.save(Book.fixture("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(
            User(
                "이희망",
                null,
                Collections.emptyList(),
                null
            )
        )
        val request = BookLoanRequest("이희망", "엘리스")

        // when
        bookService.loanBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].bookName).isEqualTo("엘리스")
        assertThat(results[0].user.name).isEqualTo("이희망")
        assertThat(results[0].user.id).isEqualTo(savedUser.id)
        assertThat(results[0].isReturn).isEqualTo(false)
    }

    @Test
    fun loanBookFailTest() {
        // given
        val savedBook = bookRepository.save(Book.fixture("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(
            User(
                "이희망",
                null,
                Collections.emptyList(),
                null
            )
        )
        val request = BookLoanRequest("이희망", "엘리스")
        userLoanHistoryRepository.save(
            UserLoanHistory(
                savedUser,
                savedBook.name,
                false
            )
        )

        // when, then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.message

        assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
    }

    @Test
    fun returnBookTest() {
        // given
        val savedBook = bookRepository.save(Book.fixture("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(
            User(
                "이희망",
                null,
                Collections.emptyList(),
                null
            )
        )
        userLoanHistoryRepository.save(
            UserLoanHistory(
                savedUser,
                savedBook.name,
                false
            )
        )
        val request = BookReturnRequest(savedUser.name, savedBook.name)

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].isReturn).isTrue
    }
}