package com.example.view;

import com.example.vo.Item;

public class Print1 {

    // 1. 물품 여러개 보관
    private Item[] items = null;

    // 2. getter/setter
    public Item[] getItems() {
        return items;
    }

    public void setItem(Item[] items) {
        this.items = items;
    }

    // 4. 메소드(실제업무)
    public void printAction() {
        for (int i = 0; i < this.items.length; i++) {
            System.out.println("----------------");
            System.out.println(this.items[i].getNo());
            System.out.println(this.items[i].getName());
            System.out.println(this.items[i].getPrice());
            System.out.println(this.items[i].getContent());
        }
    }

}
