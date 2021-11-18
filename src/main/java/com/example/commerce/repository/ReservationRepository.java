package com.example.commerce.repository;

import com.example.commerce.domain.ReservationsTable;

public interface ReservationRepository
{
    ReservationsTable saveReservation(ReservationsTable reservationsTable);
}
