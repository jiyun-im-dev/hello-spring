package com.jiyun.hellospring;

import com.jiyun.hellospring.repository.MemberRepository;
import com.jiyun.hellospring.repository.MemoryMemberRepository;
import com.jiyun.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
