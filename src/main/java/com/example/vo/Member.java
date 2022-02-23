// main / java / com / example / vo
package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// js -> const member = {_id: 'a@a.com', name:'a', role:'CUSTOMER'}
public class Member {
    // 1. 변수
    private String id = null;
    private String name = null;
    private String role = null;
    private int age = 999; // 숫자 변수는 null 사용 불가
    private String regdate = null;

}
