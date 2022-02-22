package com.example.vo;

public class Item {

    // 1.변수 설정: 물품번호, 제목, 가격, 수량
    private long no = 0L;
    private String name = null;
    private long price = 0L;
    private String content = null;

    // 2. getter/setter
    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Print1.java에서 물품번호, 제목, 가격, 수량을 출력
    @Override
    public String toString() {
        return "Item [content=" + content + ", name=" + name + ", no=" + no + ", price=" + price + "]";
    }

}
