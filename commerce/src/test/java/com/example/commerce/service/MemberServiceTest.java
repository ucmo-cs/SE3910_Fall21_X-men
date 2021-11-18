package com.example.commerce.service;

import com.example.commerce.domain.Member;
import com.example.commerce.repository.MemberRepository;
import com.example.commerce.repository.TMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//Dependency injection.
//TDD Test Driven Development


class MemberServiceTest {

    //MemberService memberService = new MemberService();
    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new TMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");
        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void joinException(){

        Member member1 = new Member();
        member1.setName("TK");
        Long saveId = memberService.join(member1);

        Member member2 = new Member();
        member2.setName("TK");

        try{
            memberService.join(member2);
            fail("fail");
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("Name is already exists");
        }


    }



    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}