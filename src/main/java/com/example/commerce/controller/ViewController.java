package com.example.commerce.controller;

import com.example.commerce.domain.Member;
import com.example.commerce.domain.ReservationsTable;
import com.example.commerce.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController
{
    private final ReservationService reservationService;

    @Autowired
    public ViewController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("main/view")
    public String list(Model model){
        List<ReservationsTable> reservations = reservationService.findReservations();
        model.addAttribute("reservations" , reservations);

        return "commerce/user-view";
    }
}
