package com.tioga.training.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tioga.training.business.domain.RoomReservation;
import com.tioga.training.business.service.ReservationService;

@RestController
@RequestMapping("api/reservations")
public class RoomReservationWebRestController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public List<RoomReservation> getRoomReservations(@RequestParam(name="date", required = false)String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }
}