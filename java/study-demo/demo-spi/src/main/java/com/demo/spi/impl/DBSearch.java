package com.demo.spi.impl;

import com.demo.spi.Search;

public class DBSearch implements Search {
    @Override
    public String search(String keyWord) {
        return "dbsearch";
    }
}
