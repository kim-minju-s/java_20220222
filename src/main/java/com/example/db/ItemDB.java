package com.example.db;

import java.util.List;
import java.util.Map;

import com.example.vo.Item;

public interface ItemDB {

    // 시퀀스를 이용해서 물품등록
    public int insertItem(Item item);

    // 물품삭제
    public int deleteItem(Item item);

    // 변경
    public int updateItem(Item item);

    // 1개 조회
    public Map<String, Object> selectOneMapItem(long code);

    public Item selectOneItem(long code);

    // 목록 조회
    public List<Item> selectListItem();

    // 페이지 단위로 조회
    public List<Item> selectListPageItem(int page);

}
