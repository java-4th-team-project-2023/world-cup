package com.pickpick.dto.search;

import com.pickpick.dto.page.Page;

public class Search extends Page {

    // 검색 키워드
    private String keyword;

    public Search() {
        this.keyword = "";
    }
}
