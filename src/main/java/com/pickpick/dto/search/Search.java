package com.pickpick.dto.search;

import com.pickpick.dto.page.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
public class Search extends Page {

    // 검색 키워드
    private String keyword;

    public Search() {
        this.keyword = "";
    }
}
