package com.pickpick.dto.reply;

import com.pickpick.dto.page.PageMaker;
import com.pickpick.entity.Reply;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplyListResponseDTO {

    private int count;
    private PageMaker pageMaker;
    private List<ReplyDetailResponseDTO> replyList;


}
