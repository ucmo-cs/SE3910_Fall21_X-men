package com.example.commerce.domain;

import javax.persistence.*;

@Entity
public class ReservationsTable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reservationID;

    @Column(name = "name")
    private String name;

    @Column(name = "sDate")
    private String sDate;

    @Column(name = "eDate")
    private String eDate;

    @Column(name = "cubicleID")
    private String cubicleID;

    @Column(name = "userID")
    private String userID;


    public String getReservationID() { return reservationID; }

    public void setReservationID(String reservationID) { this.reservationID = reservationID; }

    public String getReservationName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getReservationSDate() { return sDate; }

    public void setsDate(String sDate) { this.sDate = sDate; }

    public String getReservationEDate() { return eDate; }

    public void setEDate(String eDate) { this.eDate = eDate; }

    public String getReservationCubicleID() { return cubicleID; }

    public void setCubicleID(String cubicleID) { this.cubicleID = cubicleID; }

    public String getReservationUserID() { return userID; }

    public void setUserID(String userID) { this.userID = userID; }

}
