package com.example;

import com.example.basic.Child1;
import com.example.basic.Parent;

// 프로그램 시작위치
public class App {
    public static void main(String[] args) {

        // 클래스명 객체명 = new 생성자();

        // Parent 클래스는 미완성이기 때문에 작동하지X
        // Parent obj1 = new Parent();
        // obj1.printNum();

        Parent obj2 = new Child1();
        obj2.printNum();
        obj2.printNum1();

        // child 를 쓸 필요 없음
        // Child1 obj3 = new Child1();
        // obj3.printNum();
        // obj3.printChild1();

    }
}
