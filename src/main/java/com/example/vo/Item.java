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

public class Item {

    // 1.변수 설정: 물품번호, 제목, 가격, 수량
    private long no = 0L;
    private String name = null;
    private long price = 0L;
    private long quantity = 0L;
    private String content = null;

}
