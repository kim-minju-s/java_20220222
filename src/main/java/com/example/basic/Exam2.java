package com.example.basic;

// public 공용
// private 개인

// 클래스 생성
public class Exam2 {
    // 객체를 직접 1개 만들기
    private static Exam2 obj = new Exam2();

    // 생성자 private: 외부에서 생성 불가
    private Exam2() {

    }

    // 메소드 객체가 생성되고 호출되는 것
    // static 있으면 객체를 생성하지 않고 호출할 수 있음
    public static Exam2 create() {
        return obj;
    }

}
