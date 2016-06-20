package trabalho.poo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Bank {
    public Bank(){    }
    
    public int sizeF(){
        try{
            File file =new File("Funcionarios");
            if(!file.exists()){
                  return 0;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            int z=0;
            while(x != null){
                if(x.equals("#")){
                    z++;
                }
                x=lerArq.readLine();
            }
            arq.close();
            return z;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }  
        return 0;
    }
    
    public boolean addF(Funcionario f){
        try{
            File file =new File("Funcionarios");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println("#");
            gr.println(f.getCpf());
            gr.println(f.getNome());
            gr.println(f.getSenha());
            gr.close();
            return true;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return false;
        }
    }
    
    public Funcionario getF(String _CPF){
        Funcionario f=new Funcionario();
        try{
            File file =new File("Funcionarios");
            if(!file.exists()){
                  System.out.println("Vazio!");
                  return null;
            }
            String nome;
            String senha;
            ArrayList a=new ArrayList<>();
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
                while(k!=null){
                    if(k.equals("#")){
                        a.add("#");
                        k=ler.readLine();
                        if(k.equals(_CPF)){
                            a.add(_CPF);
                            nome=ler.readLine();
                            senha=ler.readLine();
                            a.add(nome);
                            a.add(senha);
                            f.setCpf(_CPF);
                            f.setNome(nome);
                            f.setSenha(senha);
                        }
                        else{
                            a.add(k);
                        }
                    }
                    else{
                        a.add(k);
                    }
                    k=ler.readLine();
                }         
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            int x=0;
            while(x<a.size()){
                gr.println(a.get(x));
                x++;
            }
            gr.close();
            return f;
            
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }
        
        return null;
        
    }
    
    public Funcionario getF(int k){//um a um
        Funcionario f=new Funcionario();
        try{
            File file =new File("Funcionarios");
            if(!file.exists()){
                  return null;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            int z=-1;
            while(x != null){
                if(x.equals("#")){
                    f.setCpf(lerArq.readLine());
                    f.setNome(lerArq.readLine());
                    f.setSenha(lerArq.readLine());
                    z++;
                    if(z==k){
                        return f;
                    }
                }
                x=lerArq.readLine();
            }
            arq.close();
            return f;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }  
        return null;
    }
    
    public void printAllF(){
        if(this.sizeF()>0){
            for (int k=0;k<this.sizeF();k++){
                Funcionario j=this.getF(k);
                System.out.println("================================================");
                System.out.println("Nome: " + j.getNome());
                System.out.println("CPF: " +j.getCpf());
            }
        } else{
            System.out.println("Vazio!!");
        }
    }
    
    public boolean delF(String _CPF){
        boolean b=false;
        try{
            File file =new File("Funcionarios");
            if(!file.exists()){
                  System.out.println("Vazio!");
                  return false;
            }
            ArrayList a=new ArrayList<>();
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
                while(k!=null){
                    if(k.equals("#")){  
                        k=ler.readLine();
                        if(k.equals(_CPF)){ 
                            ler.readLine();
                            ler.readLine();
                            b=true;
                        }
                        else{
                            a.add("#");
                            a.add(k);
                        }
                    }
                    else{
                        a.add(k);
                    }
                    k=ler.readLine();
                }         
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            int x=0;
            while(x<a.size()){
                gr.println(a.get(x));
                x++;
            }
            gr.close();
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   ioe.printStackTrace();
      }
        
        return b;
    }
    
    public int sizeI(){
        try{
            File file =new File("Imoveis");
            if(!file.exists()){
                return 0;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            int z=0;
            while(x != null){
                if(x.equals("#")){
                    z++;
                }
                x=lerArq.readLine();
            }
            arq.close();
            return z;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }  
        return 0;
    }
    
    public boolean addI(Imovel i){
        try{
            File file =new File("Imoveis");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println("#");
            gr.println(i.getEnd());
            gr.println(i.getAlugado());
            gr.println(i.getVendido());
            gr.println(i.getTipo());
            gr.println(i.getBairro());
            gr.println(i.getArea());
            gr.println(i.getQtdquart());
            gr.println(i.getValor());
            gr.close();
            return true;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return false;
        }
    }
    
    public Imovel getI(int k){
        Imovel i=new Imovel();
        try{
            File file =new File("Imoveis");
            if(!file.exists()){
                System.out.println("Vazio!!");
                return null;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            int z=0;
            while(x != null){
                if(x.equals("#")){
                    i.setEnd(lerArq.readLine());
                    i.setAlugado(lerArq.readLine());
                    i.setVendido(lerArq.readLine());
                    i.setTipo(lerArq.readLine());
                    i.setBairro(lerArq.readLine());
                    i.setArea(lerArq.readLine());
                    i.setQtdquart(lerArq.readLine());
                    i.setValor(lerArq.readLine());
                    z++;
                    if(z==k){
                        return i;
                    }
                }
                x=lerArq.readLine();
            }
            arq.close();
            return i;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }  
        return null;
    }
    //errado
    public void printAllI(){
        Bank b=new Bank();
        if(this.sizeI()>0){
            for(int k=1;k<=this.sizeI();k++){
                Imovel i=this.getI(k);
                System.out.println("================================================");
                System.out.println("Id: " +k);
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
        }else{
            System.out.println("Vazio!");
        }
    }
    
    public boolean delI(int kk){
        boolean b=false;
        try{
            int y=0;
            File file =new File("Imoveis");
            if(!file.exists()){
                  System.out.println("Vazio!");
                  return false;
            }
            ArrayList a=new ArrayList<>();
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
                while(k!=null){
                    if(k.equals("#")){
                        y++;
                        k=ler.readLine();
                        if(y==kk){
                            ler.readLine();
                            ler.readLine();
                            ler.readLine();
                            ler.readLine();
                            ler.readLine();
                            ler.readLine();
                            ler.readLine();
                            b=true;
                        }
                        else{
                            a.add("#");
                            a.add(k);
                        }
                    }
                    else{
                        a.add(k);
                    }
                    k=ler.readLine();
                }         
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            int x=0;
            while(x<a.size()){
                gr.println(a.get(x));
                x++;
            }
            gr.close();
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   ioe.printStackTrace();
      }
        return b;
    }
    
    public boolean addNF(String k){
        try{
            File file =new File("NotaFiscal");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println("=======================================================");
            gr.println(k);
            gr.close();
            return true;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return false;
        }
    }
    
    public String getNF(){
        String k="";
        try{
            File file =new File("NotaFiscal");
            if(!file.exists()){
                System.out.println("Nao há dados Fiscais!");
                  return null;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            while(x != null){
            k=k.concat(x+"\n");
            x=lerArq.readLine();
            }
            lerArq.close();
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return null;
        }
        return k;
    }

    public int sizeC(){
        try{
            File file =new File("Clientes");
            if(!file.exists()){
                  return 0;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            int z=0;
            while(x != null){
                if(x.equals("#")){
                    z++;
                }
                x=lerArq.readLine();
            }
            arq.close();
            return z;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }  
        return 0;
    }
    
    public boolean addC(Clientes f){
        try{
            File file =new File("Clientes");
            if(!file.exists()){
                  file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            gr.println("#");
            gr.println(f.getCPF());
            gr.println(f.getNome());
            gr.close();
            return true;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return false;
        }
    }
    
    public Clientes getC(String _CPF){
        Clientes f=new Clientes();
        boolean b=false;
        try{
            File file =new File("Clientes");
            if(!file.exists()){
                  System.out.println("Vazio!");
                  return null;
            }
            String nome;
            ArrayList a=new ArrayList<>();
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
                while(k!=null){
                    if(k.equals("#")){
                        b=true;
                        a.add("#");
                        k=ler.readLine();
                        if(k.equals(_CPF)){
                            a.add(_CPF);
                            f.setCPF(_CPF);
                            nome=ler.readLine();
                            a.add(nome);
                            f.setNome(nome);
                        }
                        else{
                            a.add(k);
                        }
                    }
                    else{
                        a.add(k);
                    }
                    k=ler.readLine();
                }         
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            int x=0;
            while(x<a.size()){
                gr.println(a.get(x));
                x++;
            }
            gr.close();
            if(b==false){
             return null;   
            }
            return f;
            
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }
        
        return null;
        
    }
    
    public Clientes getC(int k){//um a um
        Clientes f=new Clientes();
        try{
            File file =new File("Clientes");
            if(!file.exists()){
                  return null;
            }
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String x=lerArq.readLine();
            int z=-1;
            while(x != null){
                if(x.equals("#")){
                    f.setCPF(lerArq.readLine());
                    f.setNome(lerArq.readLine());
                    z++;
                    if(z==k){
                        return f;
                    }
                }
                x=lerArq.readLine();
            }
            arq.close();
            return f;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   
      }  
        return f;
    }
    
    public void printAllC(){
        if(this.sizeC()>0){
            for(int k=0;k<this.sizeC();k++){
                Clientes f=this.getC(k);
                System.out.println("================================================");
                System.out.println("Nome: "+f.getNome());
                System.out.println("CPF: " +f.getCPF());
            }
        }else{
            System.out.println("Vazio!");
        }
    }
    
    public boolean delC(String _CPF){
        boolean b=false;
        try{
            File file =new File("Clientes");
            if(!file.exists()){
                System.out.println("Vazio!");  
                return false;  
            }
            ArrayList a=new ArrayList<>();
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
                while(k!=null){
                    if(k.equals("#")){  
                        k=ler.readLine();
                        if(k.equals(_CPF)){ 
                            ler.readLine();
                            b=true;
                        }
                        else{
                            a.add("#");
                            a.add(k);
                        }
                    }
                    else{
                        a.add(k);
                    }
                    k=ler.readLine();
                }         
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            int x=0;
            while(x<a.size()){
                gr.println(a.get(x));
                x++;
            }
            gr.close();
       }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   ioe.printStackTrace();
      }
        return b;
    }
    
    public boolean addFat(String val){
        try{
            File file =new File("Faturamento");
            if(!file.exists()){
                file.createNewFile();
            }
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
            ler.close();
            Double valor=Double.parseDouble(val);
            Double x=valor;
            if(k!=null){
                x=Double.parseDouble(k);
                x=x+valor;
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter gr = new PrintWriter(bw);
            String m=""+x;
            gr.println(m);
            gr.close();
            return true;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return false;
        }
    }
    
    public Double getFat(){
        try{
            File file =new File("Faturamento");
            if(!file.exists()){
                file.createNewFile();
            }
            FileReader arq = new FileReader(file);
            BufferedReader ler = new BufferedReader(arq);
            String k=ler.readLine();
            ler.close();
            Double x;
            if(k!=null){
              x=Double.parseDouble(k);  
            }
            else{
                x=0d;
            }
            return x;
        }catch(IOException ioe){
    	   System.out.println("Exception occurred:");
    	   return null;
        }
    }
            
}
