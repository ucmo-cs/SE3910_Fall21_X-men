package com.example.commerce.domain;

import javax.persistence.*;

@Entity
public class CubicleTable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cubicleID;

    @Column(name = "sDate")
    private String sDate;

    @Column(name = "eDate")
    private String eDate;

    public String getCubicleID() { return cubicleID; }

    private void setCubicleID(String cubicleID) { this.cubicleID = cubicleID; }

    public String getSDate() { return sDate; }

    private void setSDate(String cubicleID) { this.sDate = sDate; }

    public String getEDate() { return eDate; }

    private void setEDate(String eDate) { this.eDate = eDate; }

    @Override
    public String toString()
    {
        return "CubicleTable{" +
                "cubicleID='" + cubicleID + '\'' +
                ", sDate='" + sDate + '\'' +
                ", eDate='" + eDate + '\'' +
                '}';
    }
}
