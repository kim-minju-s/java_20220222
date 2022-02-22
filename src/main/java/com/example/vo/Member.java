// main / java / com / example / vo
package com.example.vo;

// 파일명: Member.java 
// 파일명과 클래스명은 일치해야함(대소문자 구분)

// js -> const member = {_id: 'a@a.com', name:'a', role:'CUSTOMER'}
public class Member {
    // 1. 변수
    private String id = null;
    private String name = null;
    private String role = null;
    private int age = 999; // 숫자 변수는 null 사용 불가
    private String regdate = null;

    // 메소드(함수)
    // 2. getter/setter
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String b) {
        this.name = b;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String c) {
        this.role = c;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int d) {
        this.age = d;
    }

    public String getRegdate() {
        return this.regdate;
    }

    public void setRegdate(String e) {
        this.regdate = e;
    }

    // 3. toString 만들기(오른쪽 마우스, Source Action, 항목체크, ok)
    @Override
    public String toString() {
        return "Member [age=" + age + ", id=" + id + ", name=" + name + ", regdate=" + regdate + ", role=" + role + "]";
    }

}
