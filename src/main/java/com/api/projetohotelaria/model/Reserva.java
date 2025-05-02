package com.api.projetohotelaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate checkin;
    private LocalDate checkout;
    
    @ManyToOne
    private Quarto quarto;
    
    @ManyToOne
    private Hospede hospede;
    
    private int totalDias;
    private Double valorTotal;

    public Reserva() {
    }

    public Reserva(Integer id, LocalDate checkin, LocalDate checkout, Quarto quarto, Hospede hospede, int totalDias, Double valorTotal) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.quarto = quarto;
        this.hospede = hospede;
        this.totalDias = totalDias;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public int getTotalDias() {
        int dias;
        
        dias = (int) ChronoUnit.DAYS.between(checkin, checkout);

        return dias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }
    
    public Double getValorTotal() {
        return totalDias * quarto.getValor();
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }   
}
