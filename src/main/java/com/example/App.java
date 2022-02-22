package com.example;

import com.example.view.Print1;
// import com.example.view.Print;
// ctrl + space로 선택하기
// import com.example.vo.Board;
import com.example.vo.Item;

public class App {
    public static void main(String[] args) {

        // 1. 게시판 데이터를 추가함
        // Board obj = new Board();
        // obj.setNo(1);
        // obj.setTitle("제목1");
        // obj.setWriter("작성자2");
        // obj.setHit(100);
        // obj.setContent("내용1");

        // 1. 아이템 데이터 추가(Item.java)
        Item[] arr = new Item[2]; // 아이템 여러개

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Item();
            arr[i].setNo(i + 1);
            arr[i].setName("가나다");
            arr[i].setPrice(12900);
            arr[i].setContent("맛있다");
        }

        // 2. 프린트하기(Print1.java))
        Print1 obj1 = new Print1();
        obj1.setItem(arr);
        // 실제 프린트 수행
        obj1.printAction();

        // System.out.println( obj.toString() );

        // 2. 프린트하기
        // Print obj1 = new Print();
        // obj1.setBoard(obj); // 준비물 전달단계
        // obj1.printAction(); // 실제 프린트 수행시킴

    }
}
