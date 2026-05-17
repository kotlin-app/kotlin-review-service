package com.example.review.controller

import com.example.review.model.Review
import com.example.review.repository.ReviewRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// レビューサービスのRESTコントローラー
// BFFからのリクエストを受け取り、DBから商品IDに紐づくレビューを返す
@RestController
@RequestMapping("/reviews")
class ReviewController(private val repository: ReviewRepository) {

    // GET /reviews/product/{productId} → 指定商品のレビュー一覧を返す
    @GetMapping("/product/{productId}")
    fun getByProductId(@PathVariable productId: Long): List<Review> =
        repository.findByProductId(productId)
}
