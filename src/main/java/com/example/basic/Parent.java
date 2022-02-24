package com.example.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// getter/setter는 필요할 때마다 사용가능
// 생성자는 최초 한번만
public abstract class Parent { // 추상화: abstract로 명시해야함
    // 클래스의 공통변수
    private int num = 0;

    // 클래스명과 일치 생성자, 여러개 가능(오버로딩)
    public Parent() {
    }

    // 생성자
    public Parent(int num) {
        this.num = num;
    }

    // getter/setter

    // 메소드
    public void printNum() {
        System.out.println(this.num);

    }

    // 메소드는 기능구현X, 자식은 반드시 기능을 구현해야함
    // 부모는 설계용.(자식은 구현용, App.java는 이용자)
    public abstract void printNum1();

}
