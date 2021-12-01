package com.example.commerce;


import com.example.commerce.repository.*;
import com.example.commerce.service.MemberService;
import com.example.commerce.service.ReservationService;
import com.example.commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    @Bean
    public JPACubicleRepository cubicleRepository()
    {
        return new JPACubicleRepository(em);
    }

    @Bean
    public JPAReservationRepository reservationRepository()
    {
        return new JPAReservationRepository(em);
    }

    @Bean
    public ReservationService reservationService()
    {
        return new ReservationService(reservationRepository());
    }

    @Bean
    public JPALoginRepository loginRepository()
    {
        return new JPALoginRepository(em);
    }

    @Bean
    public UserService userService() {
        return new UserService(loginRepository());
    }
}
