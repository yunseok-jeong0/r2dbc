package com.yunseok.r2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("comment")
data class CommentEntity(
    @Id
    val id: Long? = null,
    val userNo: Long,
    val boardId: Long,
    val content: String,
    val createdAt: Instant,
    val updatedAt: Instant,
)
