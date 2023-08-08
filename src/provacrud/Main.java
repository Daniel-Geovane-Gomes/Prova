package provacrud;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        
        List listaProdutos = new ArrayList();
        List quantidadeProdutos = new ArrayList();
        List valorProdut = new ArrayList();
        List nomeProdutos = new ArrayList();
        List listaQtdReservada = new ArrayList();
        
        int id = 0;
        int reserva = 0;
        String fraseMenu = "Digite:\n1 para ver o estoque\n2 para adicionar produto,\n3 para excluir\n4 para atualizar\n5 Para reservar produto\n6 para cancelar reserva\n7 Para adicionar quantidade de produto\n8 Para saída do estoque";
        String fraseValUni = "Valor unitário:  ";
        String fraseQtd = "Quantidade:  ";
        String fraseReservados = "Reservados:  ";
        ArrayList produtos = new ArrayList();
        int qtd = 0;
        int op;
        op = Integer.parseInt(JOptionPane.showInputDialog(null, fraseMenu));
        while(op != 10){
        
        
        switch(op){
        case 1:
        int procura = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser procurado"));
        JOptionPane.showMessageDialog(null, produtos.get(procura));
        break;
        case 2:

        String newProduto = JOptionPane.showInputDialog("Nome do produto a ser adicionado");
        nomeProdutos.add(newProduto);
        String valorUni = (JOptionPane.showInputDialog("valor unitário"));
        valorProdut.add(valorUni);
        qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto a ser adicionado"));
        quantidadeProdutos.add(qtd);
        listaQtdReservada.add(reserva);
        produtos.add(newProduto + "\n" + fraseValUni + valorUni + "\n" + fraseQtd + qtd + "\n" + fraseReservados +reserva);
        JOptionPane.showMessageDialog(null, "Adicionado: \n" + produtos.get(id));
        id++;
        break;
        case 3:
            int idExcl = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser excluido"));
            produtos.remove(idExcl);
            nomeProdutos.remove(idExcl);
            valorProdut.remove(idExcl);
            quantidadeProdutos.remove(idExcl);
            listaQtdReservada.remove(idExcl);
        break;
        case 4:
            
            int itemAtu = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser atualizado"));
            
            String novoNome = JOptionPane.showInputDialog("Novo nome");
            String novoValUni = JOptionPane.showInputDialog("Novo valor unitário");
            String novaQtd = JOptionPane.showInputDialog("Nova quantidade");
            
            produtos.set(itemAtu, novoNome + "\n" + fraseValUni + novoValUni + "\n" + fraseQtd + novaQtd + "\n" + fraseReservados +listaQtdReservada.get(itemAtu));
            nomeProdutos.set(itemAtu, novoNome);
            valorProdut.set(itemAtu, novoValUni);
            quantidadeProdutos.set(itemAtu, novaQtd);
            
            break;
        case 5:
            
            int idReservar = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser reservado"));
            int qtdReservar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade a ser reservada"));
            listaQtdReservada.set(idReservar, qtdReservar);
            int qtdTemp = (int) quantidadeProdutos.get(idReservar);
            int newQtdDpsDeReservada =  qtdTemp - qtdReservar;
            quantidadeProdutos.set(idReservar, newQtdDpsDeReservada);
            produtos.set(idReservar, nomeProdutos.get(idReservar) + "\n" + fraseValUni + valorProdut.get(idReservar) + "\n" + fraseQtd + newQtdDpsDeReservada + "\n" + fraseReservados + qtdReservar);
            break;
        case 6:
            int idCancela = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser cancelada a reserva"));
            int qtdCancelaReserva = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade a ser cancelada da reserva"));
            int qtdReservaTemp = (int) listaQtdReservada.get(idCancela);
            int newQtdReservaDpsDeCancelar = qtdReservaTemp - qtdCancelaReserva;
            listaQtdReservada.set(idCancela, newQtdReservaDpsDeCancelar);
            qtdTemp = (int) quantidadeProdutos.get(idCancela);
            int newQtdDpsDeCancelaReserva =  qtdTemp + qtdCancelaReserva;
            quantidadeProdutos.set(idCancela, newQtdDpsDeCancelaReserva);
            produtos.set(idCancela, nomeProdutos.get(idCancela) + "\n" + fraseValUni + valorProdut.get(idCancela) + "\n" + fraseQtd + newQtdDpsDeCancelaReserva + "\n" + fraseReservados + newQtdReservaDpsDeCancelar);
            break;
        case 7:
            int idAddProd = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ter sua quantidade acrescentada"));
            int qtdSerAcrescentada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade a ser acrescentada"));
            qtdTemp = (int) quantidadeProdutos.get(idAddProd);
            int newQtdDpsDeAcrescentar =  qtdTemp + qtdSerAcrescentada;
            quantidadeProdutos.set(idAddProd, newQtdDpsDeAcrescentar);
            produtos.set(idAddProd, nomeProdutos.get(idAddProd) + "\n" + fraseValUni + valorProdut.get(idAddProd) + "\n" + fraseQtd + newQtdDpsDeAcrescentar + "\n" + fraseReservados + listaQtdReservada.get(idAddProd));
            break;
        case 8:
            int idSaidaDeEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto que vai ter seu estoque reduzido"));
            int qtdSaidaEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade que saira do estoque"));
            qtdReservaTemp = (int) listaQtdReservada.get(idSaidaDeEstoque);
            if(qtdSaidaEstoque > qtdReservaTemp){
                int qtdProdTemp = qtdReservaTemp - qtdSaidaEstoque;
                qtdTemp = (int) quantidadeProdutos.get(idSaidaDeEstoque);
                int newQtdProdDpsDeSaida = qtdTemp - qtdProdTemp;
                quantidadeProdutos.set(idSaidaDeEstoque, newQtdProdDpsDeSaida);
                int qtdReservaZero = 0;
                listaQtdReservada.set(idSaidaDeEstoque, qtdReservaZero);
                produtos.set(idSaidaDeEstoque, nomeProdutos.get(idSaidaDeEstoque) + "\n" + fraseValUni + valorProdut.get(idSaidaDeEstoque) + "\n" + fraseQtd + newQtdProdDpsDeSaida + "\n" + fraseReservados + qtdReservaZero);
            } else {
            int newQtdReservaDpsDeSair = qtdReservaTemp - qtdSaidaEstoque;
            listaQtdReservada.set(idSaidaDeEstoque, newQtdReservaDpsDeSair);
            produtos.set(idSaidaDeEstoque, nomeProdutos.get(idSaidaDeEstoque) + "\n" + fraseValUni + valorProdut.get(idSaidaDeEstoque) + "\n" + fraseQtd + quantidadeProdutos.get(idSaidaDeEstoque) + "\n" + fraseReservados + newQtdReservaDpsDeSair);
            break;
        }
        }
        op = Integer.parseInt(JOptionPane.showInputDialog(null, fraseMenu));
        }
         }
        
    }
    





    /*public class Produto {
        
        public String nome;
        public Double valorUni;
        public int qtdDisp;
        public int qtdReservada;
        
        public Produto(String nome, Double valorUni, int qtdDisp, int qtdReservada){
            this.nome = nome;
            this.valorUni = valorUni;
            this.qtdDisp= qtdDisp;
            this.qtdReservada = qtdReservada;
    }
        
        
    
        //Produto p = new Produto("nome", 1.00, 3, 8);
}
    public void addProduto(){
        String nome = JOptionPane.showInputDialog("Nome do produto a ser adicionado");
                Double valorUni = Double.parseDouble(JOptionPane.showInputDialog("valor unitário"));
                int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto a ser adicionado"));
                //int qtdReser = 0;
                Produto p = new Produto(nome, valorUni, qtd, 0);
               // listaProdutos.add(p);
                
    }
    public void searchProd(){
        String itemProcura = JOptionPane.showInputDialog("Nome do produto a ser adicionado");
        if(nome.equals(itemProcura)) {
            // listaProdutos.add(p);
            
        } else {
        }
    
}*/
    

/*
public class Produto {
        
        private String nome;
        private Double valorUni;
        private int qtdDisp;
        private int qtdReservada;
        
        public Produto(String nome, Double valorUni, int qtdDisp, int qtdReservada){
            this.nome = nome;
            this.valorUni = valorUni;
            this.qtdDisp= qtdDisp;
            this.qtdReservada = qtdReservada;
    }
        
        
    
        //Produto p = new Produto("nome", 1.00, 3, 8);
}
    public Produto addProduto(){
        String nome = JOptionPane.showInputDialog("Nome do produto a ser adicionado");
                Double valorUni = Double.parseDouble(JOptionPane.showInputDialog("valor unitário"));
                int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto a ser adicionado"));
                //int qtdReser = 0;
                Produto p = new Produto(nome, valorUni, qtd, 0);
               // listaProdutos.add(p);
               return p;
                
    }*/
