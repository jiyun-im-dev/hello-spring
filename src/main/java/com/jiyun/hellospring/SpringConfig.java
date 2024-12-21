package com.jiyun.hellospring;

import com.jiyun.hellospring.repository.JpaMemberRepository;
import com.jiyun.hellospring.repository.MemberRepository;
import com.jiyun.hellospring.repository.MemoryMemberRepository;
import com.jiyun.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

}
