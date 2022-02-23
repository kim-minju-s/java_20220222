package com.example;

import java.util.ArrayList;

import com.example.db.MemberDB;
import com.example.vo.Member;

// 프로그램 시작위치
public class App {
    public static void main(String[] args) {

        // 객체 생성
        MemberDB obj = new MemberDB();

        ArrayList<Member> list = obj.selectListData();

        // Array를 하나로 압축시켰기 때문에 반복문 사용
        for (Member tmp : list) {
            System.out.println("목록 조회" + tmp.toString());
        }

    }
}
