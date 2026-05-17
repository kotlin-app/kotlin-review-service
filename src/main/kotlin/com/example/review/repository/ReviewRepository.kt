package com.example.review.repository

import com.example.review.model.Review
import org.springframework.data.jpa.repository.JpaRepository

// レビューのCRUD操作を提供するリポジトリ
interface ReviewRepository : JpaRepository<Review, Long> {
    // 商品IDに紐づくレビューを取得するカスタムクエリ（Spring Data JPAが自動実装）
    fun findByProductId(productId: Long): List<Review>
}
