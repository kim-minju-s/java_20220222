package com.example;

import java.util.List;

import com.example.db.BoardDB;
import com.example.db.BoardDBImpl;
import com.example.vo.Board;

// 프로그램 시작위치
public class App1 {
    public static void main(String[] args) {

        BoardDB obj = new BoardDBImpl();

        List<Board> list = obj.selectListBoard();

        for (Board tmp : list) {
            System.out.println("목록 조회" + tmp.toString());
        }

    }
}

/*
 * 추가하기
 * // 0. 객체 생성, 클래스명 객체명 = new 생성자();
 * // BoardDB obj = new BoardDB();
 * BoardDB obj = new BoardDBImpl();
 * 
 * // 1. 게시판 글쓰기 수행
 * Board board = new Board(6L, "제목3", "내용3", "작성자3", 100);
 * 
 * int ret = obj.insertBoard(board);
 * System.out.println(ret);
 * 
 */

/*
 * 삭제하기
 * BoardDB obj = new BoardDBImpl();
 * 
 * Board board = new Board();
 * 
 * board.setNo(2L);
 * 
 * int ret = obj.deleteBoard(board);
 * 
 * System.out.println(ret);
 */

/*
 * 수정하기
 * BoardDB obj = new BoardDBImpl();
 * 
 * // 게시판 수정 수행
 * Board board = new Board(6L, "wpahr", "sodyd11", "wkrtjdwk32", 234);
 * 
 * int ret = obj.updateBoard(board);
 * System.out.println(ret);
 * 
 */

/*
 * 
 * 게시글 1개 조회
 * 
 * BoardDB obj = new BoardDBImpl();
 * 
 * Board board = new Board();
 * board.setNo(6L);
 * 
 * Board board1 = obj.selectOneBoard(board);
 * if (board1 != null) {
 * System.out.println("조회결과: " + board1.toString());
 * }
 * 
 */

/*
 * 목록 조회하기
 * BoardDB obj = new BoardDBImpl();
 * 
 * List<Board> list = obj.selectListBoard();
 * 
 * for (Board tmp : list) {
 * System.out.println("목록 조회" + tmp.toString());
 * }
 * 
 */