package com.example.commerce.repository;

import com.example.commerce.domain.ReservationsTable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPAReservationRepository implements ReservationRepository
{
    private final EntityManager em;

    public JPAReservationRepository(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public ReservationsTable saveReservation(ReservationsTable reservationsTable)
    {
        em.persist(reservationsTable);
        return reservationsTable;
    }

    @Override
    public int cancelReservation(String id)
    {
        Query query = em.createQuery("delete from ReservationsTable r where r.reservationID = :value");
        int deletedRows = query.setParameter("value", id).executeUpdate();
        return deletedRows;
    }
}
