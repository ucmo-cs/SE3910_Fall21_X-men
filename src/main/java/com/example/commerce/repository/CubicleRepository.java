package com.example.commerce.repository;

import com.example.commerce.domain.CubicleTable;

import java.text.ParseException;
import java.util.List;

public interface CubicleRepository
{
    List<CubicleTable> findAllCubicles();
    List<CubicleTable> findAllCubiclesBetweenDates(String startDate, String endDate) throws ParseException;
}
