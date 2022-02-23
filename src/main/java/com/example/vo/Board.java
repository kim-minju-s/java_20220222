package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// 파일명: Board.java
public class Board {
    // 1. 변수 설정: ERD 다이어그램에서 참고(맘대로 하는거 X)
    // 글번호, 제목, 내용, 작성자, 조회수
    private long no = 0L;
    private String title = null;
    private String content = null;
    private String writer = null;
    private int hit = 0;

}
