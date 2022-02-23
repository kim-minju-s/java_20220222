package com.example;

import java.util.ArrayList;

import com.example.db.BoardDB;
import com.example.vo.Board;

// 프로그램 시작위치
public class App1 {
    public static void main(String[] args) {

        BoardDB obj = new BoardDB();

        ArrayList<Board> list = obj.selectListData();

        for (Board tmp : list) {
            System.out.println("목록 조회" + tmp.toString());
        }

    }
}

/*
 * 추가하기
 * // 객체 생성
 * BoardDB obj = new BoardDB();
 * 
 * Board board = new Board();
 * board.setNo(1);
 * board.setTitle("제목1");
 * board.setContent("가나다");
 * board.setWriter("abc");
 * board.setHit(12);
 * 
 * int ret = obj.insertData(board);
 * 
 * if (ret == 1) {
 * System.out.println("추가 성공");
 * } else {
 * System.out.println("추가 실패");
 * }
 * 
 */

/*
 * 삭제하기
 * BoardDB obj = new BoardDB();
 * 
 * Board board = new Board();
 * board.setNo(2);
 * int result = obj.deleteData(board);
 * 
 * System.out.println("삭제 결과" + result);
 */

/*
 * 수정하기
 * BoardDB obj = new BoardDB();
 * 
 * Board board = new Board();
 * board.setNo(4);
 * board.setTitle("변경2");
 * board.setWriter("놛롱");
 * board.setContent("d오네양");
 * 
 * int ret = obj.updateData(board);
 * 
 * System.out.println("게시글 수정" + ret);
 * 
 */

/*
 * 
 * 게시글 1개 조회
 * // 객체 생성
 * BoardDB obj = new BoardDB();
 * 
 * Board board = new Board();
 * board.setNo(1);
 * 
 * Board board1 = obj.selectOneData(board);
 * if (board1 != null) {
 * System.out.println("조회결과: " + board1.toString());
 * }
 * 
 */