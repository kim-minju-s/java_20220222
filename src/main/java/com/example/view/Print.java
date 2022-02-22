package com.example.view;

import com.example.vo.Board;

// 화면에 출력하는 곳
// jsp, vue, react로 전환될 영역
public class Print {

    // 1. 앱이 담긴 변수 만들기
    private Board board = null;

    // 2. getter/setter
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    // 4. 제일 마지막 단계: 메소드(실제 업무)
    // 게시판 정보가 오면 글번호, 제목을 출력하는 일
    public void printAction() {
        System.out.println(this.board.toString());

        System.out.println("--------------------");
        System.out.println(this.board.getNo());
        System.out.println(this.board.getTitle());
        System.out.println("--------------------");
    }

}
