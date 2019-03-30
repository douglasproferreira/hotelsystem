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
public class PessoaFisica extends Cliente {

    private String nome;
    private String cpf;
    private String sexo;

    public PessoaFisica(String nome, String cpf, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public PessoaFisica() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    // Instância do método abstrato getCliente.
    @Override
    public String getCliente(){
        return "Id: " + this.id
                + "\n Tipo: " + this.tipo
                + "\n Nome: " + this.nome
                + "\n CPF: " +  this.cpf
                + "\n Sexo: " + this.sexo
                + "\n Endereço: " + this.endereco
                + "\n Cidade: " + this.cidade
                + "\n Estado: " + this.estado;
        
    }

    // Instância do método abstrato getIdentificacao.
    @Override
    public String getIdentificacao() {
        return this.nome;
    }
}
