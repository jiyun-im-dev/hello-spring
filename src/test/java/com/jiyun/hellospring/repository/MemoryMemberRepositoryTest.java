package com.jiyun.hellospring.repository;

import com.jiyun.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("뭉깨");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("뭉깨");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("바다표범");
        repository.save(member2);

        Member result = repository.findByName(member1.getName()).get();
        assertEquals(member1, result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("뭉깨");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("바다표범");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}