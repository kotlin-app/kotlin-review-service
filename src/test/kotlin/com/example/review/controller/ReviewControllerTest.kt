package com.example.review.controller

import com.example.review.model.Review
import com.example.review.repository.ReviewRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var repository: ReviewRepository

    @BeforeEach
    fun setUp() {
        repository.deleteAll()
        repository.saveAll(listOf(
            Review(productId = 1L, userName = "田中さん", rating = 5, comment = "最高です"),
            Review(productId = 1L, userName = "佐藤さん", rating = 4, comment = "良いです"),
            Review(productId = 1L, userName = "鈴木さん", rating = 3, comment = "普通です"),
            Review(productId = 2L, userName = "山田さん", rating = 5, comment = "素晴らしい"),
        ))
    }

    @Test
    fun `存在する商品のレビューが返る`() {
        mockMvc.get("/reviews/product/1")
            .andExpect {
                status { isOk() }
                jsonPath("$.length()") { value(3) }
                jsonPath("$[0].userName") { isNotEmpty() }
                jsonPath("$[0].rating") { isNotEmpty() }
            }
    }

    @Test
    fun `レビューが存在しない商品は空リストが返る`() {
        mockMvc.get("/reviews/product/999")
            .andExpect {
                status { isOk() }
                jsonPath("$.length()") { value(0) }
            }
    }
}
