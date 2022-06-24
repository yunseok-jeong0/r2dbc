package com.yunseok.r2dbc.repository

import com.yunseok.r2dbc.entity.CommentEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface CommentRepository : ReactiveCrudRepository<CommentEntity, Long> {
    
    fun findAllByBoardId(boardId: Long): Flux<CommentEntity>
}

