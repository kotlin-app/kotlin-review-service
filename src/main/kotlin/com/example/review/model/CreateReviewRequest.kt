package com.example.review.model

data class CreateReviewRequest(
    val productId: Long,
    val rating: Int,
    val comment: String,
)
