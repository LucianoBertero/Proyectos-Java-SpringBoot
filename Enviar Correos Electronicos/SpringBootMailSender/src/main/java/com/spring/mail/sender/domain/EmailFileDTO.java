package com.spring.mail.sender.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmailFileDTO {
    private String[] toUser;
    private String subject;
    private String body;
    private MultipartFile file;
}
