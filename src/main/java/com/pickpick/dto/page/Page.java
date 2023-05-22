package com.pickpick.dto.page;

import com.pickpick.dto.search.Search;
import lombok.*;

@Setter @Getter
@AllArgsConstructor
@ToString @Builder
public class Page{

    private int pageNo;
    private int amount;

    public Page() {
        this.pageNo = 1;
        this.amount = 6;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1 || pageNo == Integer.MAX_VALUE) {
            this.pageNo = 1;
            return;
        }
        this.pageNo = pageNo;
    }

    public void setAmount(int amount) {
        if (amount < 6 || amount > 30) {
            this.amount = 6;
            return;
        }
        this.amount = amount;
    }

    public int getPageStart() {
        return (pageNo - 1) * amount;
    }

}
