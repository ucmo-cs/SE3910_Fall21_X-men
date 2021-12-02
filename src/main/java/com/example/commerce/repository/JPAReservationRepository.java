package com.example.commerce.repository;

import com.example.commerce.domain.Member;
import com.example.commerce.domain.ReservationsTable;
import com.example.commerce.domain.UserTable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    /*@Override
    public List<ReservationsTable> findAll() {
        return em.createQuery("select r from ReservationsTable r" , ReservationsTable.class)
                .getResultList();
    }*/

    @Override
    public String findOnlineUserID() {
        return em.createQuery("select u.userid from UserTable u where u.online = 1")
                .getResultList()
                .get(0) + "";
    }

    @Override
    public List<ReservationsTable> findUserReservations(String onlineUser) {
        return em.createQuery("select r from ReservationsTable r where r.userID = :onlineUser", ReservationsTable.class)
                .setParameter("onlineUser", onlineUser)
                .getResultList();
    }
}
