package com.example.commerce.controller;

import com.example.commerce.domain.ReservationsTable;
import com.example.commerce.repository.JPACubicleRepository;
import com.example.commerce.repository.JPAReservationRepository;
import com.example.commerce.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CancelController
{
    @GetMapping("main/cancel")
    public String list(Model model){
        List<ReservationsTable> reservations = reservationService.findReservations();
        model.addAttribute("reservations" , reservations);

        return "commerce/user-cancel";
    }

    private final JPACubicleRepository cubicleRepository;
    private final JPAReservationRepository reservationRepository;
    private final ReservationService reservationService;

    public CancelController(JPACubicleRepository cubicleRepository, JPAReservationRepository reservationRepository, ReservationService reservationService) {
        this.cubicleRepository = cubicleRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @RequestMapping(value="main/cancel", method = RequestMethod.POST, params="delete")
    public String cancelRes(@RequestParam("deleteInput") String reservationID, Model model)
    {
        reservationService.delete(reservationID);
        List<ReservationsTable> reservations = reservationService.findReservations();
        model.addAttribute("reservations" , reservations);
        return "commerce/user-cancel";
    }
}

