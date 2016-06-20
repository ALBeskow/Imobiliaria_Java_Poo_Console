
package trabalho.poo1;

import java.util.Scanner;


public class Funcionario {
    
    private String nome;
    private String cpf;
    private String senha;
    
    public Funcionario(){ 
        this.cpf="";
        this.nome="";
        this.senha="";
    }
    
    public Funcionario(String _nome, String _cpf, String _senha){
        this.setCpf(_cpf);
        this.setNome(_nome);
        this.setSenha(_senha);
    }

    public String getNome() {
        return nome;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autentica(String _login, String _senha) {
        if (this.getSenha().equals(_senha) && (this.getCpf().equals(_login) || this.getNome().equals(_login))) {
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean vender(Funcionario f){
        Bank b=new Bank();
        System.out.println("Digite o CPF do cliente:");
        String ler=new Scanner(System.in).nextLine();
        Clientes c=b.getC(ler);
        if(c==null){
            System.out.println("Cliente inexistente! Você precisa adicionar antes");
        }
        else if(c.getCPF().equals(ler)){
        System.out.println("Digite o ID do Imovel que deseja vender: ");
        int k=new Scanner(System.in).nextInt();
        if(k>b.sizeI() || k<1){
            System.out.println("Nao encontrado!!");
        }else{
        Imovel i=b.getI(k);
        if(i!=null){
            if(i.getVendido().equals("Nao")){
                b.delI(k);
                i.setVendido(c.getCPF());
                i.setAlugado("Nao");
                b.addI(i);
                String kk=f.getNome();
                if(kk.equals("admin")){
                    kk="Gerente";
                }
                System.out.println("Vendido!! Para: " + c.getNome());
                b.addNF("Vendido pelo Funcionario "+ kk +"\n"+
                        "CPF: "+ f.getCpf()+"\n"+
                        "um Imóvel localizado na: " + i.getEnd()+
                        "\nBairro: "+i.getBairro()+"\nPara: "+c.getNome()+
                        "\nCPF: "+c.getCPF()+"\n"+
                        "Pelo preço de: "+i.getValor()+"\n");
                b.addFat(i.getValor());
                return true;
            }
        }
        else{
            System.out.println("Nao ha imoveis!");
        }
        }
        }else{
            System.out.println("Cliente inexistente! Você precisa adicionar antes");
        }
        return false;
    }
    
    public void alugar(Funcionario f){
        Bank b=new Bank();
        System.out.println("Digite o CPF do cliente:");
        String ler=new Scanner(System.in).nextLine();
        Clientes c=b.getC(ler);
        if(c==null){
            System.out.println("Cliente inexistente! Você precisa adicionar antes");
        }
        else if(c.getCPF().equals(ler)){
        System.out.println("Digite o ID do Imovel que deseja Alugar: ");
        int k=new Scanner(System.in).nextInt();
        if(k>b.sizeI() || k<1){
            System.out.println("Nao encontrado!!");
        }else{
        Imovel i=b.getI(k);
        if(i!=null){
            if(i.getVendido().equals("Nao") && i.getAlugado().equals("Nao")){
                b.delI(k);
                i.setAlugado(c.getCPF());
                b.addI(i);
                String kk=f.getNome();
                if(kk.equals("admin")){
                    kk="Gerente";
                }
                System.out.println("Alugado!! Para: " + c.getNome());
                b.addNF("Alugado pelo Funcionario "+ kk +"\n"+
                        "CPF: "+ f.getCpf()+"\n"+
                        "um Imóvel localizado na: " + i.getEnd()+
                        "\nBairro: "+i.getBairro()+"\nPara: "+c.getNome()+
                        "\nCPF: "+c.getCPF()+"\n"+
                        "Pelo preço de: "+i.getValor()+"\n");
                b.addFat(i.getValor());
            }
        }else{
            System.out.println("Nao ha imoveis!");
        }
        }
        }else{
            System.out.println("Cliente inexistente! Você precisa adicionar antes");
        }   
    }
    
    public boolean modificarImovel(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        Imovel i;
        System.out.println("digite o ID de qual deseja modificar: ");
        int k=new Scanner(System.in).nextInt();
        if(k>b.sizeI() || k<1){
            System.out.println("Nao encontrado!!");
            return false;
        }
        i=b.getI(k);
        if(!i.getAlugado().equals("Nao") && !i.getVendido().equals("Nao")){
            System.out.println("Esse Imóvel Foi Alugado ou Vendido!");
            System.out.println("Nao pode modificar!");
            return false;
        }
        else{
        if(b.getI(k)!=null){
        b.delI(k);
        System.out.println("Digite o Endereço: ");
        i.setEnd(sc.nextLine());
        System.out.println("Digite o tipo de Imovel: ");
        i.setTipo(sc.nextLine());
        System.out.println("Digite o Bairro: ");
        i.setBairro(sc.nextLine());
        System.out.println("Digite a Area: ");
        i.setArea(new Scanner(System.in).nextLine());
        System.out.println("Digite a quantia de quartos: ");
        i.setQtdquart(new Scanner(System.in).nextLine());
        System.out.println("Digite o valor: ");
        i.setValor(new Scanner(System.in).nextLine());
        if(new Bank().addI(i))
            System.out.println("Modificado!!");
        else
            System.out.println("Erro!!");
        }
        else{
            System.out.println("Nao Localizado!");
        }
        }
        return true;
    }
    
    public void verImoveis(){
        Bank b=new Bank();
        if(b.sizeI()>0){
            b.printAllI();
        }else{
            System.out.println("Vazio!");
        }
    }
    
    public boolean delImoveis(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        Imovel i;
        System.out.println("digite o ID do Imóvel: ");
        int k=new Scanner(System.in).nextInt();
        if(k>b.sizeI() || k<1){
            System.out.println("Nao encontrado!!");
            return false;
        }
        if(b.delI(k)){
            return true;
        }
        return false;
    }
   
    
    public void infi(){
        Imobiliaria im=new Imobiliaria();
        Bank b=new Bank();
        im.setFat(b.getFat());
        System.out.println("Imobiliária: " + im.getNome());
        System.out.println("Localização: " + im.getEnd());
        System.out.println("CNPJ: " + im.getCnpj());
        System.out.println("Faturamento Total: " + im.getFat());
    }
    
    public void seeImoveis(){
        new Bank().printAllI();
    }
    
    public void verSuasInformacoes(){
        System.out.println("Nome:  " +this.getNome());
        System.out.println("CPF:   " +this.getCpf());
        System.out.println("Senha: " +this.getSenha());
    }
    
    public void ChangeInfo(){
        System.out.println("Digite o novo Nome: ");
        this.setNome(new Scanner(System.in).nextLine());
        System.out.println("Digite o a nova senha: ");
        this.setSenha(new Scanner(System.in).nextLine());
        System.out.println("O CPF não Pode ser Modificado!!");
        new Bank().delF(this.getCpf());
        if(new Bank().addF(this))
            System.out.println("ok,informações atualizadas!!");
        else
            System.out.println("Ocorreu um erro!!");
    }
    
    public void verImoveisAlu(){
        Bank b=new Bank();
        int x=0;
        if(b.sizeF()>0){
            for(int k=1;k<=b.sizeI();k++){
                Imovel i=b.getI(k);
                if(!i.getAlugado().equals("Nao")){
                    x++;
                System.out.println("================================================");
                System.out.println("Id: " +k);
                System.out.println("Endereço: " +i.getEnd());
                System.out.println("Tipo: "+i.getTipo());
                System.out.println("Bairro: "+i.getBairro());
                System.out.println("Area: " + i.getArea());
                System.out.println("Quantia de Quartos: " + i.getQtdquart());
                System.out.println("Valor: " + i.getValor());
                }
            }
        }else{
            System.out.println("Vazio!!");
        }
        if(x==0){
            System.out.println("Nenhum Imovel Alugado!");
        }
    }
    
    public void verImoveisVend(){
        Bank b=new Bank();
        int x=0;
        if(b.sizeF()>0){
            for(int k=1;k<=b.sizeI();k++){
                Imovel i=b.getI(k);
                if(!i.getVendido().equals("Nao")){
                    x++;
                System.out.println("================================================");
                System.out.println("Id: " +k);
                System.out.println("Endereço: " +i.getEnd());
                System.out.println("Tipo: "+i.getTipo());
                System.out.println("Bairro: "+i.getBairro());
                System.out.println("Area: " + i.getArea());
                System.out.println("Quantia de Quartos: " + i.getQtdquart());
                System.out.println("Valor: " + i.getValor());
                }
            }
        }else{
            System.out.println("Vazio!!");
        }
        if(x==0){
            System.out.println("Nenhum Imovel Vendido!");
        }
    }
    
    public boolean addCli(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do novo Cliente:");
        String _nome=sc.nextLine();
        System.out.println("Digite o CPF do novo Cliente:");
        String _cpf=sc.nextLine();
        Clientes F= new Clientes(_nome,_cpf);
        if(new Bank().addC(F)){
            System.out.println("Adicionado!");
            return true;
        }
        else{
            System.out.println("Erro!!");
        }
        return false;
    }
    
    public boolean delCli(){
        System.out.println("Digite o CPF:");
        String _cpf=new Scanner(System.in).nextLine();
        Bank b = new Bank();
        for(int z=0;z<b.sizeI();z++){
            Imovel i=b.getI(z);
            if(i.getAlugado().equals(_cpf) || i.getVendido().equals(_cpf)){
                System.out.println("Não pode ser Excluido!!");
                System.out.println("Esse cliente possui relação com imóveis!");
                return false;
            }  
        }
        
        for (int x=0;x<b.sizeC();x++){
            Clientes c=(Clientes)b.getC(x);
            if(c.getCPF().equals(_cpf)){
                
                if(b.delC(_cpf))
                return true;
            }
        }
        return false;
    }
    
    public boolean modCli(){
        boolean bo=false;
        System.out.println("Digite o CPF:");
        String _cpf=new Scanner(System.in).nextLine();
        Bank b = new Bank();
        for (int x=0;x<b.sizeC();x++){
            Clientes F=(Clientes)b.getC(x);
            if(F.getCPF().equals(_cpf)){
                if(b.delC(_cpf))
                bo=true;
            }
        }
        if(bo=true){
        System.out.println("Digite o nome do novo Cliente:");
        String _nome=new Scanner(System.in).nextLine();
        Clientes F= new Clientes(_nome,_cpf);
        if(new Bank().addC(F)){
            System.out.println("Adicionado!");
            return true;
        }
        else{
            System.out.println("Erro!!");
        }
        }
        System.out.println("Erro ao Modificar! Provavelmente não localizado!");
        return false;
        
    }
    
    public void seeCli(){
        new Bank().printAllC();
    }
    
    public void seeOneImo(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite o Id:");
        int id=sc.nextInt();
        if(id>b.sizeI() || id<1){
            System.out.println("Nao encontrado!!");
        }else{
        Imovel i=b.getI(id);
        System.out.println("================================================");
        System.out.println("Id: " +id);
        System.out.println("Endereço: " +i.getEnd());
        System.out.println("Tipo: "+i.getTipo());
        System.out.println("Bairro: "+i.getBairro());
        System.out.println("Area: " + i.getArea());
        System.out.println("Quantia de Quartos: " + i.getQtdquart());
        System.out.println("Valor: " + i.getValor());
        if(!i.getAlugado().equals("Nao")){
            Clientes c=b.getC((String)i.getAlugado());
            System.out.println("Alugado para: "+ c.getNome());
        }else if(!i.getVendido().equals("Nao")){
            Clientes c=b.getC((String)i.getVendido());
            System.out.println("Vendido para: "+ c.getNome());
        }else{
            System.out.println("Vago!");
        }
    }
    }
    
    public void seeOneCli(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite o CPF:");
        String _cpf=sc.nextLine();
        Clientes F=b.getC(_cpf);
        if(F!=null){
            if(F.getCPF().equals(_cpf)){
                System.out.println("Nome: " + F.getNome());
                System.out.println("CPF: " + F.getCPF());
            }else{
                System.out.println("Nao encontrado!");
            }
        }
        else{
            System.out.println("Nao encontrado!");   
        }
    }
    
}
