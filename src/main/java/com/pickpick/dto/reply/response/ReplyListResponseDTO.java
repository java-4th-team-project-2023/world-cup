package com.pickpick.dto.reply.response;

import com.pickpick.dto.page.PageMaker;
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
    private List<ReplyDetailResponseDTO> replyList;


}
