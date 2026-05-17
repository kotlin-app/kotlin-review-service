package com.example.review.model

import jakarta.persistence.*

@Entity
@Table(name = "reviews")
class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val productId: Long,
    val userName: String,
    val rating: Int,
    val comment: String,
)
