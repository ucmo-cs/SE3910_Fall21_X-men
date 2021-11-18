package com.example.commerce.repository;
import com.example.commerce.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TMemberRepositoryTest {

    MemberRepository repository = new TMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearstore();
    }


    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // expected output, actual output
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring3");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring4");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}