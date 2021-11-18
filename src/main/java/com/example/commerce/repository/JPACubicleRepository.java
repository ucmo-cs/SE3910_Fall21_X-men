package com.example.commerce.repository;

import com.example.commerce.domain.CubicleTable;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JPACubicleRepository implements CubicleRepository
{
    private final EntityManager em;

    public JPACubicleRepository(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public List<CubicleTable> findAllCubicles()
    {
        return em.createQuery("select c from CubicleTable c", CubicleTable.class).getResultList();
    }

    @Override
    public List<CubicleTable> findAllCubiclesBetweenDates(String startDate, String endDate) throws ParseException
    {
        List<CubicleTable> availableCubicles = new ArrayList<CubicleTable>();

        Calendar calendar = Calendar.getInstance();
        Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        List<CubicleTable> allTables = findAllCubicles();
        for (CubicleTable cubicle : allTables)
        {
            String cubicleStartDate = cubicle.getSDate();
            String cubicleEndDate = cubicle.getEDate();

            Date cubicleStartDateAsDate = new SimpleDateFormat("MM/dd/yy").parse(cubicleStartDate);
            Date cubicleEndDateAsDate = new SimpleDateFormat("MM/dd/yy").parse(cubicleEndDate);

            if ((sDate.after(cubicleStartDateAsDate) || sDate.equals(cubicleStartDateAsDate))
                    && (eDate.before(cubicleEndDateAsDate) || eDate.equals(cubicleEndDateAsDate)))
            {
                availableCubicles.add(cubicle);
            }
        }

        return availableCubicles;
    }
}
