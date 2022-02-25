package com.example.db;

import java.util.List;
import java.util.Map;

import com.example.vo.Item;

public interface ItemDB {

    // 시퀀스를 이용해서 물품등록
    public int insertItem(Item item);

    // 물품삭제: throws Exception 추가(자동으로 오류 처리)
    public int deleteItem(long code) throws Exception;

    // 변경
    public int updateItem(Item item) throws Exception;

    // 1개 조회
    public Map<String, Object> selectOneMapItem(long code);

    public Item selectOneItem(long code);

    // 목록 조회
    public List<Item> selectListItem() throws Exception;

    // 페이지 단위로 조회
    public List<Item> selectListPageItem(int page);

}
