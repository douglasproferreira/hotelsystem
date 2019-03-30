/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author Douglas e João
 */
public class PessoaJuridica extends Cliente {
    
    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    // Instância do método abstrato getCliente.
    @Override
    public String getCliente(){
        return "Id: " + this.id
                + "\n Tipo: " + this.tipo
                + "\n Razão Social: " + this.razaoSocial
                + "\n CNPJ: " +  this.cnpj
                + "\n Endereço: " + this.endereco
                + "\n Cidade: " + this.cidade
                + "\n Estado: " + this.estado;
        
    }
    
    // Instância do método abstrato getIdentificacao.
    @Override
    public String getIdentificacao() {
        return this.razaoSocial;
    }
 
}
