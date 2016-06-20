/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.poo1;

/**
 *
 * @author alvin
 */
public class Imovel {
    private String tipo;
    private String end;
    private String alugado;
    private String vendido;
    private String bairro;
    private String area;
    private String qtdquart;
    private String valor;
    
    public Imovel(){
        this.tipo="";
        this.end="";
        this.bairro="";
        this.area="0";
        this.qtdquart="0";
        this.valor="0";
        this.alugado="Nao";
        this.vendido="Nao";
    }
    
    public Imovel(String _tipo, String _end, String _bairro,String _area, String _qtd,String _valor){
        this.tipo=_tipo;
        this.end=_end;
        this.bairro=_bairro;
        this.area=_area;
        this.qtdquart=_qtd;
        this.valor=_valor;
    } 
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQtdquart() {
        return qtdquart;
    }

    public void setQtdquart(String qtdquart) {
        this.qtdquart = qtdquart;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the alugado
     */
    public String getAlugado() {
        return alugado;
    }

    /**
     * @param alugado the alugado to set
     */
    public void setAlugado(String alugado) {
        this.alugado = alugado;
    }

    /**
     * @return the vendido
     */
    public String getVendido() {
        return vendido;
    }

    /**
     * @param vendido the vendido to set
     */
    public void setVendido(String vendido) {
        this.vendido = vendido;
    }
       
}