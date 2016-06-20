/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.poo1;

/**
 *
 * @author Alvin
 */
public class Clientes {
    private String nome;
    private String CPF;
    
    public Clientes(){
        this.nome="";
        this.CPF="";
    }
    
    public Clientes(String Nome,String Cpf){
        this.nome=Nome;
        this.CPF=Cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
