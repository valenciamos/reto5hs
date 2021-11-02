package co.usa.recursosh.recursosh.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursosh.recursosh.model.Reservation;
import co.usa.recursosh.recursosh.repository.CountClient;
import co.usa.recursosh.recursosh.repository.ReservationRepository;
import co.usa.recursosh.recursosh.repository.StatusReservation;

@Service

public class ReservationService {
   
    @Autowired
    private ReservationRepository reservationRepository;

       public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

        public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    
    public Reservation save(Reservation rsvt) {
        if (rsvt.getIdReservation() == null) {
            return reservationRepository.save(rsvt);
        } else {
            Optional<Reservation> consulta = reservationRepository.getReservation(rsvt.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepository.save(rsvt);
            } else {
                return rsvt;

            }
        }
    }

    // update
    public Reservation update(Reservation rsvt) {
        if (rsvt.getIdReservation() != null) {
            Optional<Reservation> consulta = reservationRepository.getReservation(rsvt.getIdReservation());
            if (!consulta.isEmpty()) {
                if (rsvt.getStartDate() != null) {
                    consulta.get().setStartDate(rsvt.getStartDate());
                }
                if (rsvt.getDevolutionDate() != null) {
                    consulta.get().setDevolutionDate(rsvt.getDevolutionDate());
                }
                if (rsvt.getStatus() != null) {
                    consulta.get().setStatus(rsvt.getStatus());
                }
                reservationRepository.save(consulta.get());
                return consulta.get();
            } else {
                return rsvt;
            }
        } else {
            return rsvt;
        }
    }

    /*  
    * Delete
    */
    public boolean deleteReservation(int reservationId) {
        Boolean rBoolean = getReservation(reservationId).map(message -> {
            reservationRepository.delete(message);
            return true;
        }).orElse(false);
        return rBoolean;
    }

    public StatusReservation reporteStatusServicio() {
        List<Reservation> completed = reservationRepository.ReservacionStatusRepositorio("completed");
        List<Reservation> cancelled = reservationRepository.ReservacionStatusRepositorio("cancelled");

        return new StatusReservation(completed.size(), cancelled.size());
    }

    // reporte tiempo
    public List<Reservation> reporteTiempoServicio(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return reservationRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();

        }
    }
    // reporete clientes

    public List<CountClient> reporteClientesServicio() {
        return reservationRepository.getClientesRepositorio();
    }
}
