package com.pickpick.util.upload;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class fileUtil {
    public static String uploadFile(
            MultipartFile file,
            String rootPath
    ) {

//        원본 파일명을 중복이 없는 랜덤으로 이름 변경
        String newFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        String newPath = makeDateFormatDirectory(rootPath);

        try {
            file.transferTo(new File(newPath, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fullPath =  newPath + "/" + newFileName;

        return "/local"+fullPath.substring(rootPath.length());
    }

    private static String makeDateFormatDirectory(String rootPath) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        List<String> date = List.of(String.valueOf(year), pattern(month), pattern(day));
        String directory = rootPath;
        for (String s : date) {
            directory +="/" +s;
            File f = new File(directory);
            if(!f.exists()) {
                f.mkdirs();
            }
        }

        return directory;




    }

    private static String pattern(int n) {

        return new DecimalFormat("00").format(n);
    }


}
