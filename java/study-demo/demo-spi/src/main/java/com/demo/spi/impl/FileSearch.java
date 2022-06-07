package com.demo.spi.impl;

import com.demo.spi.Search;

public class FileSearch implements Search {
    @Override
    public String search(String keyWord) {
        return "file search";
    }
}
