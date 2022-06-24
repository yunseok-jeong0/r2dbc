package com.yunseok.r2dbc.service

import com.yunseok.r2dbc.dto.BoardDto
import com.yunseok.r2dbc.repository.BoardRepository
import com.yunseok.r2dbc.repository.CommentRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BoardService(
    val boardRepository: BoardRepository,
    val commentRepository: CommentRepository,
) {
    fun findById(id: Long): Mono<BoardDto> {
        return Mono.just(
            BoardDto(
                boardRepository.findById(id),
                commentRepository.findAllByBoardId(id)
            )
        )
    }
}
