package com.pickpick.dto.page;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

    private static final int PAGE_COUNT = 5;
    // 화면 렌더링시 페이지의 시작값과 끝값
    private int begin, end, finalPage;

    // 이전, 다음 버튼 활성화 여부
    private boolean prev, next;

    // 현재 요청 페이지 정보
    private Page page;

    // 총 게시물 수
    private int totalCount;

    public PageMaker(Page page, int totalCount) {
        this.page = page;
        this.totalCount = totalCount;
        makePageInfo();
    }

    private void makePageInfo() {
        this.end = (int) Math.ceil(page.getPageNo() / (double) PAGE_COUNT) * PAGE_COUNT;
        this.begin = this.end - PAGE_COUNT + 1;
        this.finalPage = (int) Math.ceil((double) totalCount / page.getAmount());
        if (this.finalPage < this.end) this.end = this.finalPage;
        this.prev = begin > 1;
        this.next = end < this.finalPage;
    }
}
