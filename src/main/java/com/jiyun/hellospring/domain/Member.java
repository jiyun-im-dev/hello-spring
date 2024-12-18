package com.jiyun.hellospring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;     // 회원 ID (자동 설정)
    private String name; // 이름

}