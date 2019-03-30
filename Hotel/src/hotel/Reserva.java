/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @authores Douglas e João
 */
public class Reserva {
    
    private Quarto quarto;
    private String responsavelQuarto;
    private int quantidadeDias;
    private double valorReserva;

    public Reserva() {
        
    }

    public Reserva(Quarto quarto, String responsavelQuarto, int quantidadeDias, double valorReserva) {
        this.quarto = quarto;
        this.responsavelQuarto = responsavelQuarto;
        this.quantidadeDias = quantidadeDias;
        this.valorReserva = valorReserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getResponsavelQuarto() {
        return responsavelQuarto;
    }

    public void setResponsavelQuarto(String responsavelQuarto) {
        this.responsavelQuarto = responsavelQuarto;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }
    
    // Método que retorna o valor da hospedagem
    public double calcularValorHosp(int quantidadeHospedes, int quantidadeDias) {
        if (quantidadeHospedes == 1) {
            return quantidadeDias * 100.00;
        } else if (quantidadeHospedes == 2) {
            return quantidadeDias * 180.00;
        } else {
            return quantidadeDias * 230.00;
        }
    }

}
