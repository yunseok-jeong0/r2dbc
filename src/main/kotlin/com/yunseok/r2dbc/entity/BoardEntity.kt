package com.yunseok.r2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("board")
data class BoardEntity(
    @Id
    val id: Long? = null,
    val title: String,
    val userNo: Long,
    val content: String,
    val createdAt: Instant,
    val updatedAt: Instant,
)
