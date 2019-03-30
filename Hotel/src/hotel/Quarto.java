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
public class Quarto {

    private int numeroQuarto;
    private int quantidadeHospedes;
    private String status;

    public Quarto() {

    }

    public Quarto(int numeroQuarto, int quantidadeHospedes, String status) {
        this.numeroQuarto = numeroQuarto;
        this.quantidadeHospedes = quantidadeHospedes;
        this.status = status;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public void setQuantidadeHospedes(int quantidadeHospedes) {
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // Método que verifica a quantidade de hóspedes
    public boolean verificarQtdadeHospedes(int quantidadeHospedes) {
        return quantidadeHospedes <= 3;
    }
    
    // Método que retorna os dados para listagem.
    public String getQuarto (){
        return "Número do Quarto: " + this.quantidadeHospedes 
                + "\n Quantidade de Hospedes: " + this.quantidadeHospedes
                + "\n Status do Quarto: " + this.status;
    }
}
