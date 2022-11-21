package com.platform.service.impl;

import com.platform.dao.ReservationDao;
import com.platform.domain.Reservation;
import com.platform.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationDao.findById(id);
    }

    @Override
    public int create(Reservation reservation) {
        return reservationDao.create(reservation);
    }

    @Override
    public int update(Integer id, Reservation reservation) {
        return reservationDao.update(id, reservation);
    }

    @Override
    public int delete(Integer id) {
        return reservationDao.delete(id);
    }
}
