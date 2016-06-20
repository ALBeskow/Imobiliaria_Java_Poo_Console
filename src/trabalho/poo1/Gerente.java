package trabalho.poo1;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Funcionario {

    public Gerente(){
        this.setNome("admin");
        this.setCpf("666 v25.80");
        this.setSenha("admin");
    }

    public void addFunc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do novo Funcionario:");
        String _nome=sc.nextLine();
        System.out.println("Digite o CPF do novo Funcionario:");
        String _cpf=sc.nextLine();
        System.out.println("Digite a Senha do novo Funcionario:");
        String _senha=sc.nextLine();
        Funcionario F= new Funcionario(_nome,_cpf,_senha);
        if(new Bank().addF(F))
            System.out.println("Adicionado!");
        else
            System.out.println("Erro!!");
    }
    
    public boolean delFunc(){
        System.out.println("Digite o CPF:");
        String _cpf=new Scanner(System.in).nextLine();
        Bank b = new Bank();
        for (int x=0;x<b.sizeF();x++){
            Funcionario F=(Funcionario)b.getF(x);
            if(F.getCpf().equals(_cpf)){
                if(b.delF(_cpf))
                return true;
            }
        }
        return false;
    }
    
    public void addImovel(){
        Imovel i=new Imovel();
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite o tipo de Imovel: ");
        i.setTipo(sc.nextLine());
        System.out.println("Digite o Endereço: ");
        i.setEnd(sc.nextLine());
        System.out.println("Digite o Bairro: ");
        i.setBairro(sc.nextLine());
        System.out.println("Digite a Area: ");
        i.setArea(new Scanner(System.in).nextLine());
        System.out.println("Digite a quantia de quartos: ");
        i.setQtdquart(new Scanner(System.in).nextLine());
        System.out.println("Digite o valor: ");
        i.setValor(new Scanner(System.in).nextLine());
        if(new Bank().addI(i))
            System.out.println("Adicionado!");
        else
            System.out.println("Erro!!");
    }
    
    public boolean delImovel(String _id){
        Bank b = new Bank();
        System.out.println("Digite o id do Imovel que deseja remover:");
        if(b.delI(new Scanner(System.in).nextInt())){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String gerarNotaFiscal(){
        Bank b=new Bank();
        Imobiliaria im=new Imobiliaria();
        im.setFat(b.getFat());
        String k="Imobiliária: " + im.getNome()+"\n"+
                "Localização: " + im.getEnd()+"\n"+
                "CNPJ: " + im.getCnpj()+"\n"+
                "Faturamento Total: " + im.getFat()+"\n";
        return k+b.getNF();
    }
    
    public void modFunc(){
        Bank bank=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite o CPF da pessoa:");
                String __cpf=sc.nextLine();
                if(bank.delF(__cpf)){
                    Funcionario ffg=new Funcionario();
                    ffg.setCpf(__cpf);
                    System.out.println("Digite o Nome:");
                    ffg.setNome(sc.nextLine());
                    System.out.println("Digite a Senha:");
                    ffg.setSenha(sc.nextLine());
                }else{System.out.println("Não encontrado!");}
    }
    
    public void seefunc(){
        new Bank().printAllF();
    }
    
    public void seeOneFunc(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite o CPF:");
        String _cpf=sc.nextLine();
        Funcionario F=b.getF(_cpf);
        if(F!=null){
            if(F.getCpf().equals(_cpf)){
                System.out.println("Nome: " + F.getNome());
                System.out.println("CPF: " + F.getCpf());
                System.out.println("Senha: " + F.getSenha());
            }else{
                System.out.println("Nao encontrado!");
            }
        }else{
            System.out.println("Nao encontrado!");
        }
    }
  
    
    public void listImoTipo(){
        Bank b=new Bank();
        Imovel i=new Imovel();
        String k;
        ArrayList imo=new ArrayList<>();
        ArrayList tipe=new ArrayList<>();
        
        for(int x=1;x<=b.sizeI();x++){
            imo.add(b.getI(x));
        }
        
        for(int x=1;x<=b.sizeI();x++){
            i=b.getI(x);
            k=i.getTipo();
            if(tipe.isEmpty()){
                tipe.add(k);
            }
            else{
                boolean bo=false;
                for(int t=0;t<tipe.size();t++){
                    String kk=(String)tipe.get(t);
                    if(kk.equals(k)){
                        bo=true;
                    }
                }
                if(!bo){
                    tipe.add(k);
                }
            }
        }
        if(i!=null){
            for(int y=0;y<tipe.size();y++){
                for(int x=0;x<imo.size();x++){
                    k=(String)tipe.get(y);
                    i=(Imovel)imo.get(x);
                    if(k.equals(i.getTipo())){
                        System.out.println("Tipo: "+i.getTipo());
                        System.out.println("================================================");
                        System.out.println("Id: " +(x+1));
                        System.out.println("Endereço: " +i.getEnd());
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
                        System.out.println("================================================");
                    }
                }
            
            }
            
        }
        else{
            System.out.println("Vazio!!");
        }
        
    }
}
