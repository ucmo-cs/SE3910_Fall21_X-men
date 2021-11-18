package com.example.commerce.service;

import com.example.commerce.domain.ReservationsTable;
import com.example.commerce.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ReservationService
{
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public String join(ReservationsTable reservationsTable)
    {
        reservationRepository.saveReservation(reservationsTable);
        return reservationsTable.getReservationID();
    }
}
