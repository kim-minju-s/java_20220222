package com.example;

import com.example.db.ItemDB;
import com.example.db.ItemDBImpl;
import com.example.vo.Item;

// 프로그램 시작위치
public class App1 {
    public static void main(String[] args) {

        ItemDB obj = new ItemDBImpl();

        try {
            Item item = new Item(9L, "와랄ㄹㄷ1", 5200L, 78L, "내용수정");

            int ret = obj.updateItem(item);

            System.out.println("수정하기" + ret);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * 페이지 조회
         * int page = 1;
         * 
         * List<Item> list = obj.selectListPageItem(page);
         * 
         * for (Item tmp : list) {
         * System.out.println("페이지 조회" + tmp);
         * }
         */

        /*
         * 목록 조회(항목 1개 제외)
         * try {
         * 
         * List<Item> list = obj.selectListItem();
         * 
         * for (Item tmp : list) {
         * System.out.println("목록 조회" + tmp.toString());
         * }
         * 
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

        /*
         * // 컬렉션 => 수집
         * // ex) array => ["aaa", "bbb", "ccc"]
         * List<String> list1 = new ArrayList<>();
         * 
         * // ex) json => {"id":"aaa", "name":"bbb", "age":12}
         * // 키를 이용해서 1개 수집에 용이, 순차적인 일 X
         * Map<String, String> map1 = new HashMap<>();
         */

        // 3. 1개 조회
        // Map<String, Object> map = obj.selectOneMapItem(7L);
        // System.out.println(map.get("ID"));
        // System.out.println(map.get("NAME"));
        // System.out.println(map.get("PRICE"));
        // System.out.println(map.get("QTY"));

        // Item item = obj.selectOneItem(7L);
        // System.out.println(item.getNo());
        // System.out.println(item.getName());
        // System.out.println(item.getPrice());
        // System.out.println(item.getQuantity());

        // 2. 삭제하기
        /*
         * try {
         * int ret = obj.deleteItem(6L);
         * System.out.println(ret);
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

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