/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.poo1;

import java.util.Scanner;

/**
 *
 * @author alvin
 */
public class Menu {
    
    public Menu(){    }
    
    public void Gerente(){
        Scanner sc=new Scanner(System.in);
        this.limpaConsole();
        System.out.println("Seja bem vindo Gerente!");
        Gerente g=new Gerente();
        boolean k=false;
        while(!k){
            System.out.println("===============================================================================================");
            System.out.println("|                                    O que deseja fazer?                                      |");
            System.out.println("|                                           Digite:                                           |");
            System.out.println("===============================================================================================");
            System.out.println("| seeF | para Ver todos os Funcionarios;       | seoF | para Ver um Funcionario por CPF;      |");
            System.out.println("| seeI | para Ver todos os Imoveis;            | seoI | para Ver um Imóvel por Id;            |");            
            System.out.println("| seeC | para Ver todos os Clientes;           | seoC | para Ver um Cliente por CPF;          |");
            System.out.println("===============================================================================================");
            System.out.println("| addF | para Adicionar um novo Funcionario;   | selI | para Vender um Imovel;                |");
            System.out.println("| addI | para Adicionar um novo Imovel;        | renI | para Alugar um Imovel;                |");
            System.out.println("| addC | para Adicionar um Cliente;            | genI | para Gerar o relatório da Nota Fiscal;|");
            System.out.println("===============================================================================================");
            System.out.println("| delF | para Excluir um Funcionario;          | infI | para Informações da Imobiliaria;      |");
            System.out.println("| delI | para Excluir um Imovel;               | seiR | para Ver todos os Imoveis Alugados;   |");
            System.out.println("| delC | para Excluir um Cliente;              | seiS | para Ver todos os Imoveis Vendidos;   |");
            System.out.println("===============================================================================================");
            System.out.println("| modF | para Modificar um Funcionario;        | extR | ta com tempo? Da um lida nisso haha   |");
            System.out.println("| modI | para Modificar um Imóvel;             | logO | para Deslogar;                        |");
            System.out.println("| modC | para Modificar um Cliente;            | exiT | para SAIR!!                           |");
            System.out.println("===============================================================================================");
            System.out.println("| lisT | para Listar por Tipo;                 | ExCa | para Exportar/Carregar Aquivos        |");
            System.out.println("===============================================================================================");
            String op=new Scanner(System.in).nextLine().toLowerCase();
            if(!op.equals("exit"))
                this.limpaConsole();
            System.out.println("================================================");
            if(op.equals("seef")){
                g.seefunc();
            }
            else if(op.equals("seei")){
                g.verImoveis();
            }
            else if(op.equals("seec")){
                g.seeCli();
            }
            else if(op.equals("addf")){
                g.addFunc();
            }
            else if(op.equals("addi")){
                g.addImovel();
            }
            else if(op.equals("addc")){
                g.addCli();
            }
            else if(op.equals("delf")){
                g.delFunc();
            }
            else if(op.equals("deli")){
                g.delImoveis();
            }
            else if(op.equals("delc")){
                g.delCli();
            }
            else if(op.equals("modf")){
                g.modFunc();
            }
            else if(op.equals("modi")){
                g.modificarImovel();
            }
            else if(op.equals("modc")){
                g.modCli();
            }
            else if(op.equals("seof")){
                g.seeOneFunc();
            }
            else if(op.equals("seoi")){
                g.seeOneImo();
            }
            else if(op.equals("seoc")){
                g.seeOneCli();
            }
            else if(op.equals("seli")){
                g.vender(g);
            }
            else if(op.equals("reni")){
                g.alugar(g);
            }
            else if(op.equals("geni")){
                System.out.println(g.gerarNotaFiscal());
            }
            else if(op.equals("infi")){
                g.infi();
            }
            else if(op.equals("seir")){
                g.verImoveisAlu();
            }
            else if(op.equals("seis")){
                g.verImoveisVend();
            }
            else if(op.equals("extr")){
                System.out.println(":3");
            }
            else if(op.equals("logo")){
                new Login().login();
                k=true;
            }
            else if(op.equals("exit")){
                k=true;
            }
            else if(op.equals("list")){
                g.listImoTipo();
            }
            else if(op.equals("exca")){
                new Arquivos().arqMenu();  
            }
            else{
                System.out.println("OI? :D");
            }
        }
    }
    
    public void Funcionario(Funcionario f){
        this.limpaConsole();
        System.out.println("Seja bem vindo " + f.getNome());
        boolean k=false;
        while(!k){
            System.out.println("===============================================================================================");
            System.out.println("|                                     O que deseja fazer?                                     |");
            System.out.println("|                                            Digite:                                          |");
            System.out.println("===============================================================================================");
            System.out.println("| seeM | para Ver suas informações;            | seiS | para Ver todos os Imoveis Vendidos;   |");
            System.out.println("| modM | para Alterar suas Informações;        | seiR | para Ver todos os Imoveis Alugados;   |");
            System.out.println("===============================================================================================");
            System.out.println("| selI | para Vender um Imovel;                | lisT | para Ver os Imóveis por Tipo;         |");
            System.out.println("| renI | para Alugar um Imovel;                | seoI | para Ver um Imóvel por Id;            |");
            System.out.println("| modI | para Modificar um Imóvel;             | seoC | para Ver um Cliente por CPF;          |");
            System.out.println("| addC | para Adicionar um Cliente;            | infI | para informações da Imobiliaria;      |");
            System.out.println("===============================================================================================");
            System.out.println("| seeI | para Ver todos os Imoveis;            | logO | para Deslogar;                        |");            
            System.out.println("| seeC | para Ver todos os Clientes;           | exiT | para SAIR!!                           |");
            System.out.println("===============================================================================================");
            String op=new Scanner(System.in).nextLine().toLowerCase();
            if(!op.equals("exit"))
                this.limpaConsole();
            System.out.println("================================================");
            if(op.equals("seem")){
                f.verSuasInformacoes();
            }
            else if(op.equals("modm")){
                f.ChangeInfo();
            }
            else if(op.equals("seli")){
                f.vender(f);
            }
            else if(op.equals("reni")){
                f.alugar(f);
            }
            else if(op.equals("modi")){
                f.modificarImovel();
            }
            else if(op.equals("addc")){
                f.addCli();
            }
            else if(op.equals("seei")){
                f.verImoveis();
            }
            else if(op.equals("seec")){
                f.seeCli();
            }
            else if(op.equals("seis")){
                f.verImoveisVend();
            }
            else if(op.equals("seir")){
                f.verImoveisAlu();
            }
            else if(op.equals("seoi")){
                f.seeOneImo();
            }
            else if(op.equals("seoc")){
                f.seeOneCli();
            }
            else if(op.equals("infi")){
                f.infi();
            }
            else if(op.equals("logo")){
                new Login().login();
                k=true;
            } 
            else if(op.equals("exit")){
                k=true;
            }
            else {
                System.out.println("Estagiários...\nGerente ta de Olho!!");
            }   
        }
    }
    
    public void limpaConsole(){
        for(int x=0;x<50;x++){
            System.out.println("");
        }
    }
    
}
