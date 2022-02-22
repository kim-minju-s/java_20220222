package com.example.vo;

// 파일명: Board.java
public class Board {
    // 1. 변수 설정: ERD 다이어그램에서 참고(맘대로 하는거 X)
    // 글번호, 제목, 내용, 작성자, 조회수
    private long no = 0L;
    private String title = null;
    private String content = null;
    private String writer = null;
    private int hit = 0;

    // 2. getter/setter (오른쪽 마우스, Source Action)
    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    // 3. toString()
    @Override
    public String toString() {
        return "Board [content=" + content + ", hit=" + hit + ", no=" + no + ", title=" + title + ", writer=" + writer
                + "]";
    }

    // 4. 메소드(함수)

}
