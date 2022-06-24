package com.yunseok.r2dbc.controller

import com.yunseok.r2dbc.dto.BoardDto
import com.yunseok.r2dbc.entity.BoardEntity
import com.yunseok.r2dbc.repository.BoardRepository
import com.yunseok.r2dbc.service.BoardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/board")
class BoardController(
    private val boardService: BoardService,
    private val boardRepository: BoardRepository,
) {
    
    @GetMapping("")
    fun findAll(): Flux<BoardEntity> {
        return boardRepository.findAll()
    }
    
    @GetMapping("/ids")
    fun findAllIds(): Flux<String> {
        return boardRepository.findAll().map { it.title }
    }
    
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long,
    ): Mono<BoardDto> {
        return boardService.findById(id)
    }
}
