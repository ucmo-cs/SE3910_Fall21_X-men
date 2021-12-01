package com.example.commerce.repository;

import com.example.commerce.domain.Member;
import com.example.commerce.domain.ReservationsTable;

import java.util.List;

public interface ReservationRepository
{
    ReservationsTable saveReservation(ReservationsTable reservationsTable);
    int cancelReservation(String id);

    List<ReservationsTable> findAll();
}
