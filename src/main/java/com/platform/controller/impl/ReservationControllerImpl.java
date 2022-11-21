package com.platform.controller.impl;

import com.platform.controller.ReservationController;
import com.platform.domain.Reservation;
import com.platform.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ReservationControllerImpl implements ReservationController {
    @Autowired
    ReservationService reservationService;

    @Override
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationService.findById(id);
    }

    @Override
    public int create(Reservation reservation) {
        return reservationService.create(reservation);
    }

    @Override
    public int update(Integer id, Reservation reservation) {
        return reservationService.update(id, reservation);
    }

    @Override
    public int delete(Integer id) {
        return reservationService.delete(id);
    }
}
