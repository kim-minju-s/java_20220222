package com.example.basic;

// 제너릭
// 파일명: Exam1.java
public class Exam1<E> {
    // private int num = 0; // 숫자형
    private E name = null; // 타입이 정해지지 않음.

    // name을 변경하기
    public void setData(E na) {
        this.name = na;
    }

    // name값 가져가기
    public E getData() {
        return this.name;
    }
}
