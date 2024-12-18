package com.jiyun.hellospring.service;

import com.jiyun.hellospring.domain.Member;
import com.jiyun.hellospring.repository.MemberRepository;
import com.jiyun.hellospring.repository.MemoryMemberRepository;
import com.sun.source.tree.MemberReferenceTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원가입")
    void join() {
        // given
        Member member = new Member();
        member.setName("뭉깨");

        // when
        Long savedId = memberService.join(member);

        // then
        Member foundMember = memberService.findById(savedId).get();
        assertEquals(member.getName(), foundMember.getName());
    }

    @Test
    @DisplayName("중복 회원가입 예외")
    public void joinDuplicate() {
        // given
        Member member1 = new Member();
        member1.setName("뭉깨");

        Member member2 = new Member();
        member2.setName("뭉깨");

        // when
        memberService.join(member1);
        // 두 번째 파라미터인 로직을 실행할 때 첫 번째 파라미터인 예외가 발생해야 함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
        assertEquals(member2.getName() + "은/는 이미 존재하는 회원입니다.", e.getMessage());
    }

    @Test
    @DisplayName("모든 회원 조회")
    void findAll() {
    }

    @Test
    @DisplayName("ID로 회원 조회")
    void findById() {
    }

}