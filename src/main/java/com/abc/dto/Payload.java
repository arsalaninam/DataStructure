package com.abc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Payload {

    private String from;
    private String limit;
    private String page;
    private String size;
    private List<Item> items;
    private String total;

    @Override
    public String toString() {
        return "ClassPojo [from = " + from + ", limit = " + limit + ", page = " + page + ", size = " + size + ", items = " + items + ", total = " + total + "]";
    }
}
