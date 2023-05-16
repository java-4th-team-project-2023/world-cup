package com.pickpick.dto.search;

import com.pickpick.dto.page.Page;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Setter @Getter @ToString
public class Search extends Page {

    // 검색 키워드
    private String keyword;

    public Search(int pageNo, int amount, String keyword) {
        super(pageNo, amount);
        this.keyword = keyword;
    }

}
