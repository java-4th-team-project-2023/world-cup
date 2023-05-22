package com.pickpick.dto.game;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInsertRequestDTO {

    private String gameName;
    private String  accountId;

    private String playerName;
    private MultipartFile[] multipartFiles;

}
