package co.usa.recursosh.recursosh.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.recursosh.recursosh.model.Client;
import co.usa.recursosh.recursosh.model.Reservation;

import co.usa.recursosh.recursosh.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    @Autowired
    ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
        
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save (Reservation rsvt){
        return reservationCrudRepository.save(rsvt);
    }

    public void delete(Reservation rsvt){
        reservationCrudRepository.delete(rsvt);
    }
    
    public List<Reservation> ReservacionStatusRepositorio (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<CountClient> getClientesRepositorio(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i<report.size(); i++){
        res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));

        }
        return res;
    }





}
