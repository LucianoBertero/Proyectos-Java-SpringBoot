package com.spring.mail.sender.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//con record te hace full los getters
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class  EmailDTO {
    private String[] toUser;
    private String subject;
    private String body;
}
