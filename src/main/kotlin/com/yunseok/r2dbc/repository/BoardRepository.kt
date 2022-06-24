package com.yunseok.r2dbc.repository

import com.yunseok.r2dbc.entity.BoardEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface BoardRepository : ReactiveCrudRepository<BoardEntity, Long> {
    
    fun findAllByUserNo(userNo: Long): Flux<BoardEntity>
}
