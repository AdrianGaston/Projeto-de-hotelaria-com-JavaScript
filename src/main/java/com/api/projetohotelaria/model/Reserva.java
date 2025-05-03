package com.api.projetohotelaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name="reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate checkin;
    private LocalDate checkout;
    
    @Column(name="total_dias")
    private int totalDias;
    
    @Column(name="valor_total")
    private Double valorTotal;

    @ManyToOne
    private Quarto quarto;

    @ManyToOne
    private Hospede hospede;

    public Reserva() {
    }

    public Reserva(Integer id, LocalDate checkin, LocalDate checkout, Quarto quarto, Hospede hospede) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.quarto = quarto;
        this.hospede = hospede;
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
        return totalDias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //Método para calcular o total de dias
    public int calcularTotalDias() {
        if (checkin != null && checkout != null) {
            return (int) ChronoUnit.DAYS.between(checkin, checkout);
        }
        return 0;
    }

    //Método para calcular o valor total conforme o quarto e a quantidade de dias
    public Double calcularValorTotal() {
            return (double) calcularTotalDias() * quarto.getValor();
    }
}