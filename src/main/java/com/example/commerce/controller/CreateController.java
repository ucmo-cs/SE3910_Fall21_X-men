package com.example.commerce.controller;

import com.example.commerce.domain.CubicleTable;
import com.example.commerce.domain.ReservationsTable;
import com.example.commerce.repository.JPACubicleRepository;
import com.example.commerce.repository.JPAReservationRepository;
import com.example.commerce.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class CreateController
{
    private final JPACubicleRepository cubicleRepository;
    private final JPAReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @Autowired
    public CreateController(JPACubicleRepository cubicleRepository, JPAReservationRepository reservationRepository, ReservationService reservationService)
    {
        this.cubicleRepository = cubicleRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @GetMapping("main/create")
    public String login()
    {
        return "commerce/user-create";
    }

    @RequestMapping(value = "main/create", method = RequestMethod.POST, params = "view")
    public String viewCubicles(CreateForm form, Model model) throws ParseException
    {
        List<CubicleTable> availableCubicles = cubicleRepository.findAllCubiclesBetweenDates(form.getStartDay(), form.getEndDay());
        model.addAttribute("cubicles", availableCubicles);
        return "commerce/user-create";
    }

    // @RequestMapping(value="main/create", method=RequestMethod.POST, params="reserve")
    @PostMapping(value = "main/create", params = "reserve")
    public String addReservation(CreateForm form, @RequestParam("cubicle") String cubicle)
    {
        ReservationsTable reservation = new ReservationsTable();
        reservation.setUserID(form.getID());
        reservation.setsDate(form.getStartDay());
        reservation.setEDate(form.getEndDay());
        reservation.setCubicleID(cubicle);
        reservationService.join(reservation);
        return "commerce/user-create";
    }

    @RequestMapping(value="main/create", params="back")
    public String goBack()
    {
        return "commerce/user-main";
    }
}
