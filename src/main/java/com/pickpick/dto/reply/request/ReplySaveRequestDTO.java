package com.pickpick.dto.reply.request;

import com.pickpick.entity.Reply;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplySaveRequestDTO {

    @NotNull
    @Min(2) @Max(8)
    private String writer;
    @NotNull
    private String text;
    private int gameId;
    private String accountId;

    public Reply toEntity(){
        return Reply.builder()
                .gameId(this.gameId)
                .writer(this.writer)
                .text(this.text)
                .build();
    }
}
