package com.example.basic;

// 상속이란..
// Parent 는 라이브러리이고
// Child1 을 만드는데 기존기능 + 새로운기능 추가
public class Child1 extends Parent implements Parent1 {
    // implements: interface Parent1 추가(n개 추가 가능)

    public Child1() {
        super();
        // 이런 생성자 호출 => public Parent()
    }

    public Child1(int num) {
        // super: 부모의 생성자를 호출
        super(num);
        // 이런 생성자 호출 => public Parent(int num)
    }

    @Override // 부모의 기능을 재구현(부모의 구현부 + 자식의 구현부)
    public void printNum() {

        super.printNum();
        // 부모의 메소드가 호출됨
        System.out.println("child1에서 출력");
    }

    // 부모와 전혀 상관없는 메소드
    public void printChild1() {
        System.out.println("printChild1");
    }

    @Override
    public void printNum1() {
        System.out.println("printChild-printNum1");

    }

    @Override
    public void printA() {

    }

    @Override
    public void printB() {

    }

}
