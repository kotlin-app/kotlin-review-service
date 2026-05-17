package com.example.review.controller

import com.example.review.model.CreateReviewRequest
import com.example.review.model.Review
import com.example.review.repository.ReviewRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Tag(name = "Reviews", description = "商品レビューAPI")
@RestController
@RequestMapping("/reviews")
class ReviewController(private val repository: ReviewRepository) {

    @Operation(summary = "商品レビュー一覧取得", description = "指定した商品IDに紐づくレビュー一覧を返します")
    @ApiResponse(responseCode = "200", description = "取得成功（レビューなしの場合は空リスト）")
    @GetMapping("/product/{productId}")
    fun getByProductId(
        @Parameter(description = "商品ID") @PathVariable productId: Long
    ): List<Review> =
        repository.findByProductId(productId)

    @Operation(summary = "レビュー投稿", description = "商品にレビューを投稿します。X-User-Name ヘッダーで投稿者名を受け取ります（BFF が付与）")
    @ApiResponse(responseCode = "201", description = "投稿成功")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createReview(
        @RequestBody req: CreateReviewRequest,
        @RequestHeader("X-User-Name", defaultValue = "anonymous") userName: String,
    ): Review {
        require(req.rating in 1..5) { "rating must be between 1 and 5" }
        return repository.save(Review(productId = req.productId, userName = userName, rating = req.rating, comment = req.comment))
    }
}
