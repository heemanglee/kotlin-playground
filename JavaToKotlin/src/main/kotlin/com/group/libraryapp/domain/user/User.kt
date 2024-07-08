package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import java.util.Collections
import javax.persistence.*

/**
 * JPA Entity는 data class를 지양한다.
 * data class -> equals, hashcode, toString 구현
 * User, UserLoanHistory는 1:N관계, equals()를 호출하면 서로 순환 참조
 */
@Entity
class User(
    var name: String,
    val age: Int? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = Collections.emptyList(),

    @Id
    @GeneratedValue
    val id: Long? = null
) {

    init {
        if (this.name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun loanBook(book: Book) {
        this.userLoanHistories.add(UserLoanHistory(this, book.name, UserLoanStatus.LOANED, null))
    }

    fun returnBook(name: String) {
        val targetHistory = this.userLoanHistories.stream()
            .filter() { history -> history.bookName == name }
            .findFirst()
            .orElseThrow()
        targetHistory.doReturn()
    }
}