package com.yunseok.r2dbc.service

import com.yunseok.r2dbc.entity.BoardEntity
import com.yunseok.r2dbc.entity.CommentEntity
import com.yunseok.r2dbc.repository.BoardRepository
import com.yunseok.r2dbc.repository.CommentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant

@SpringBootTest
class BoardServiceTest {
    
    @Autowired
    lateinit var sut: BoardService
    
    @Autowired
    lateinit var boardRepository: BoardRepository
    
    @Autowired
    lateinit var commentRepository: CommentRepository
    
    @Test
    fun findById() {
        boardRepository.save(BoardEntity(null, "제목", 1, "내용", Instant.now(), Instant.now())).block()
        commentRepository.saveAll(
            listOf(
                CommentEntity(null, 1, 1, "댓글1", Instant.now(), Instant.now()),
                CommentEntity(null, 1, 1, "댓글2", Instant.now(), Instant.now()),
            )
        ).blockLast()
        val actual = sut.findById(1).block()
        assertThat(actual)
    }
}
