package trabalho.poo1;
public class Imobiliaria {
    final static String nome="Gilson & Cia";
    final static String cnpj="25.806.666";
    final static String end="Pindamonhangaba";
    private double faturamento;
    
    Imobiliaria(){    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEnd() {
        return end;
    }

    public double getFat() {
        return faturamento;
    }

    public void setFat(double faturamento) {
        this.faturamento = faturamento;
    }
        
      
}
