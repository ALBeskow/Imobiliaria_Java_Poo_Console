/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.poo1;

import java.util.Scanner;

/**
 *
 * @author Alvin
 */
public class Login {
    public Login(){    }
    
    public void login(){
        Gerente gerente = new Gerente();
        Bank banco = new Bank();
        Menu menu = new Menu();
        boolean z = false;
        String _login, _senha;
        Scanner sc = new Scanner(System.in);
        new Menu().limpaConsole();
        while (!z) {
            
            System.out.println("Digite o Nome ou CPF:");
            _login = sc.nextLine();
            System.out.println("Digite sua Senha:");
            _senha = sc.nextLine();
            if (gerente.autentica(_login, _senha)) {
                menu.Gerente();
                z = true;
            } else {
                for (int x = 0; x < banco.sizeF(); x++) {
                    Funcionario f = (Funcionario) banco.getF(x);
                    if (f.autentica(_login, _senha)) {
                        menu.Funcionario(f);
                        z = true;
                    }
                } 
            } new Menu().limpaConsole();
            if (!z) {
                System.out.println("Hey, esse Usuário Não Existe!!\nTente Novamente!!");
            }
        }
    }
}
