package com.yunseok.r2dbc.dto

import com.yunseok.r2dbc.entity.BoardEntity
import com.yunseok.r2dbc.entity.CommentEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

data class BoardDto(
    val boardEntity: Mono<BoardEntity>,
    val commentEntities: Flux<CommentEntity>,
)
