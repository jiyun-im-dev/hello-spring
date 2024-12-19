package com.jiyun.hellospring.controller;

import lombok.Getter;
import lombok.Setter;

// 회원가입 화면에서 데이터를 전달받을 폼 객체
@Getter
@Setter
public class NewMemberForm {

    private String name; // 회원 이름

}