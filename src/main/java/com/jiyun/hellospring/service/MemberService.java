package com.jiyun.hellospring.service;

import com.jiyun.hellospring.domain.Member;
import com.jiyun.hellospring.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
                    throw new IllegalStateException(member.getName() + "은/는 이미 존재하는 회원입니다.");
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