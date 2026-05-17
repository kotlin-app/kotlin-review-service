package com.example.review.controller

import com.example.review.model.Review
import com.example.review.repository.ReviewRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}
