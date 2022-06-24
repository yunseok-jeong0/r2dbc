CREATE TABLE board(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title VARCHAR(256) NOT NULL,
    content VARCHAR(2048) NOT NULL,
    user_no BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE comment(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    board_id BIGINT NOT NULL,
    content VARCHAR(2048) NOT NULL,
    user_no BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);