package com.jiyun.hellospring.service;

import com.jiyun.hellospring.domain.Member;
import com.jiyun.hellospring.repository.MemberRepository;
import com.jiyun.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {
        ensureUniqueName(member);

        memberRepository.save(member);
        return member.getId();
    }

    // 이름 중복 여부 체크
    private void ensureUniqueName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException(member.getName() + "은 이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

}