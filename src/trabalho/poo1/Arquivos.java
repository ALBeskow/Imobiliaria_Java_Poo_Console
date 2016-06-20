package trabalho.poo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvin
 */
public class Arquivos {
    public Arquivos(){
        
    }
    public void arqMenu(){
        boolean k=false;
        
        while(!k){
            System.out.println("=================================================");
            System.out.println("| Menu de Importação e Exportação de Arquivos:  |");
            System.out.println("| Irão para o diretório, com formato .txt       |");
            System.out.println("|                    Digite:                    |");
            System.out.println("=================================================");
            System.out.println("| expI | para exportar a Tabela Imoveis;        |");
            System.out.println("| expF | para exportar a Tablea Funcionarios;   |");
            System.out.println("| expC | para exportar a Tabela Clientes;       |");
            System.out.println("| exNF | para exportar as Notas Fiscais;        |");
            System.out.println("=================================================");
            System.out.println("| forI | para ver o Formato de importação;      |");
            System.out.println("=================================================");
            System.out.println("| impI | para importar a Tabela Imóveis;        |");
            System.out.println("| impF | para importar a Tabela Funcionarios;   |");
            System.out.println("| impC | para importar a Tabela Clientes;       |");
            System.out.println("=================================================");
            System.out.println("| exiT | para SAIR!                             |");
            System.out.println("=================================================");
            System.out.println("|Notas: todos os arquivos de importação         |");
            System.out.println("|devem estar formatados, digite: | forI |       |");
            System.out.println("=================================================");
            String op=new Scanner(System.in).nextLine().toLowerCase();
            new Menu().limpaConsole();
            if(op.equals("expi")){
                this.exportaImoveis();
            }
            else if(op.equals("expf")){
                this.exportaFunc();
            }
            else if(op.equals("expc")){
                this.exportaClientes();
            }
            else if(op.equals("exnf")){
                this.exportaNF();
            }
            else if(op.equals("fori")){
                this.fori();
            }
            else if(op.equals("impi")){
                if(this.importarImoveis()){
                    System.out.println("Importado com Sucesso!!");
                }
            }
            else if(op.equals("impf")){
                if(this.importarFuncionarios()){
                    System.out.println("Importado com Sucesso!!");
                }
            }
            else if(op.equals("impc")){
                if(this.importarClientes()){
                    System.out.println("Importado com Sucesso!!");
                }
            }
            else if(op.equals("exit")){
                k=true;
            }
            else{
                System.out.println("Algo de errado!");
            }
            
        } 
    }
    
    
    public void exportaImoveis(){
        Bank b=new Bank();
        if(b.sizeF()>0){
            String x="";
            for(int k=1;k<=b.sizeI();k++){
                Imovel i=b.getI(k);
                x=x.concat("#\n"+i.getEnd()+"\n"+
                            i.getAlugado()+"\n"+
                            i.getVendido()+"\n"+
                            i.getTipo()+"\n"+
                            i.getBairro()+"\n"+
                            i.getArea()+"\n"+
                            i.getQtdquart()+"\n"+
                            i.getValor()+"\n");
            }
            try{
            File file =new File("Exportação dos Imóveis.txt");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println(x);
            gr.close();
                System.out.println("Arquivo Exportado para o diretório!!");
                System.out.println("seu nome:\nExportação dos Imóveis.txt");
            }catch(IOException ioe){
                
            }
        }else{
            System.out.println("Nao é possivel Exportar!");
        }
    }
    public void exportaFunc(){
        Bank b=new Bank();
        String x="";
        if(b.sizeF()>0){
            for (int k=0;k<b.sizeF();k++){
                Funcionario j=b.getF(k);
                x=x.concat("#\n" + j.getCpf()+"\n"+
                        j.getNome()+"\n"+
                        j.getSenha()+"\n");
            }
            try{
            File file =new File("Exportação dos Funcionários.txt");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println(x);
            gr.close();
                System.out.println("Arquivo Exportado para o diretório!!");
                System.out.println("seu nome:\nExportação dos Funcionários.txt");
            }catch(IOException ioe){
                
            }
        } else{
            System.out.println("Vazio!!");
        }
    }
    
    public void exportaClientes(){
        Bank b=new Bank();
        String x="";
        if(b.sizeC()>0){
            for(int k=0;k<b.sizeC();k++){
                Clientes f=b.getC(k);
                x=x.concat("#\n" + f.getCPF()+"\n"+
                        f.getNome()+"\n");
            }
            try{
            File file =new File("Exportação dos Clientes.txt");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println(x);
            gr.close();
                System.out.println("Arquivo Exportado para o diretório!!");
                System.out.println("seu nome:\nExportação dos Clientes.txt");
            }catch(IOException ioe){
                
            }
        }else{
            System.out.println("Vazio!");
        }
    }
    
    public void exportaNF(){
        
        Gerente g=new Gerente();
                String x=g.gerarNotaFiscal();
                try{
            File file =new File("Exportação das Notas Fiscais.txt");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println(x);
            gr.close();
                System.out.println("Arquivo Exportado para o diretório!!");
                System.out.println("seu nome:\nExportação das Notas Fiscais.txt");
            }catch(IOException ioe){
                
            }
        
    }
    
    public void fori(){
        boolean z=false;
        while(!z){
            
            System.out.println("=================================================");
            System.out.println("Sempre use dados consistentes!!!");
            System.out.println("Caso você Importe tabelas inválidas, o software");
            System.out.println("irá quebrar:");
            System.out.println("=================================================");
            System.out.println("Motivo:");
            System.out.println("Quando é feita a busca de imóveis, e caso esse");
            System.out.println("tenha sido Vendido/Alugado, ele irá até a ");
            System.out.println("tabela clientes, caso não exista quebra.");
            System.out.println("BUGS por dados inválidos não serão corrigidos nessa Versão!");
            System.out.println("=================================================");
            System.out.println("Digite:");
            System.out.println("| imoV | para ver o formato dos Imóveis;");
            System.out.println("| funC | para ver o formato dos Funcionarios;");
            System.out.println("| cliE | para ver o formato dos Clientes;");
            System.out.println("| exiT | para voltar!");
            String op1=new Scanner(System.in).nextLine().toLowerCase();
            if(op1.equals("imov")){
                System.out.println("#");
                System.out.println("Endereço");
                System.out.println("CPF de quem alugou; Default = Nao");
                System.out.println("CPF de quem comprou; Default = Nao");
                System.out.println("Tipo");
                System.out.println("Bairro");
                System.out.println("Area");
                System.out.println("Quantia de Quantos");
                System.out.println("Valor");
                System.out.println("#");
                System.out.println("Endereço");
                System.out.println("CPF de quem alugou; Default = Nao");
                System.out.println("CPF de quem comprou; Default = Nao");
                System.out.println("Tipo");
                System.out.println("Bairro");
                System.out.println("Area");
                System.out.println("Quantia de Quantos");
                System.out.println("Valor");
            }
            else if(op1.equals("func")){
                System.out.println("#");
                System.out.println("CPF");
                System.out.println("Nome");
                System.out.println("Senha");
                System.out.println("#");
                System.out.println("CPF");
                System.out.println("Nome");
                System.out.println("Senha");
            }
            else if(op1.equals("clie")){
                System.out.println("#");
                System.out.println("CPF");
                System.out.println("Nome");
                System.out.println("#");
                System.out.println("CPF");
                System.out.println("Nome");
            }
            else if(op1.equals("exit")){
                z=true;
            }
            else{
                System.out.println("Algo de errado!");
            }
        }
    }
    
    public boolean importarImoveis(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("A partir de agora todos os arquivos serão apagados,");
        System.out.println("apenas o Backup será mantido!!");
        System.out.println("Digite o local do arquivo de Backup:");
        String k=sc.nextLine();
        String x;
        try{
            File f=new File(k);
            if(!f.exists()){
                System.out.println("Nao foi localizado!!");
                return false;
            }
            k="";
            FileReader arq = new FileReader(f);
            BufferedReader lerArq = new BufferedReader(arq);
            x=lerArq.readLine();
            while(x!=null){
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
            }
            lerArq.close();
            File file =new File("Imoveis");
                if(!file.exists()){
                      file.createNewFile();
                }
            FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter gr = new PrintWriter(bw);
                gr.println(k);
                gr.close();
                return true;
        }catch(IOException ioe){
            return false;
        } 
    }
    
    public boolean importarFuncionarios(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("A partir de agora todos os arquivos serão apagados,");
        System.out.println("apenas o Backup será mantido!!");
        System.out.println("Digite o local do arquivo de Backup:");
        String k=sc.nextLine();
        String x;
        try{
            File f=new File(k);
            if(!f.exists()){
                System.out.println("Nao foi localizado!!");
                return false;
            }
            k="";
            FileReader arq = new FileReader(f);
            BufferedReader lerArq = new BufferedReader(arq);
            x=lerArq.readLine();
            while(x!=null){
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
            }
            lerArq.close();
            File file =new File("Funcionarios");
                if(!file.exists()){
                      file.createNewFile();
                }
            FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter gr = new PrintWriter(bw);
                gr.println(k);
                gr.close();
                return true;
        }catch(IOException ioe){
            return false;
        } 
    }
    
    public boolean importarClientes(){
        Bank b=new Bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("A partir de agora todos os arquivos serão apagados,");
        System.out.println("apenas o Backup será mantido!!");
        System.out.println("Digite o local do arquivo de Backup:");
        String k=sc.nextLine();
        String x;
        try{
            File f=new File(k);
            if(!f.exists()){
                System.out.println("Nao foi localizado!!");
                return false;
            }
            k="";
            FileReader arq = new FileReader(f);
            BufferedReader lerArq = new BufferedReader(arq);
            x=lerArq.readLine();
            while(x!=null){
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
                k=k.concat(x+"\n");
                x=lerArq.readLine();
            }
            lerArq.close();
            File file =new File("Clientes");
                if(!file.exists()){
                      file.createNewFile();
                }
            FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter gr = new PrintWriter(bw);
                gr.println(k);
                gr.close();
                return true;
        }catch(IOException ioe){
            return false;
        } 
    }
    
    
}
