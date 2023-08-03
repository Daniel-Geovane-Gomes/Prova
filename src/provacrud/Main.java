package provacrud;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        //List<Produto> listaProdutos = new ArrayList<Produto>();
        List listaProdutos = new ArrayList();
        int id = 1s;
        String fraseValUni = "   Valor unitário:  ";
        String fraseQtd = "   Quantidade:  ";
        ArrayList produtos = new ArrayList();
        int qtd = 0;
        int op;
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 para ver o estoque, 2 para adicionar produto, 3 para excluir ou 4 para atualizar"));
        while(op != 5){
        
        
        switch(op){
        case 1:
        int procura = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser procurado"));
        JOptionPane.showMessageDialog(null, produtos.get(procura));
        break;
        case 2:
        produtos.add(id);
        String newProduto = JOptionPane.showInputDialog("Nome do produto a ser adicionado");
        String valorUni = (JOptionPane.showInputDialog("valor unitário"));
        qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto a ser adicionado"));
        produtos.add(newProduto + fraseValUni + valorUni + fraseQtd + qtd);
        id++;
        break;
        case 3:
            int idExcl = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser excluido"));
            produtos.remove(idExcl);
        break;
        case 4:
            int itemAtu = Integer.parseInt(JOptionPane.showInputDialog(null, "id do produto a ser atualizado"));
            String novoNome = JOptionPane.showInputDialog("Novo nome");
            String novoValUni = JOptionPane.showInputDialog("Novo valor unitário");
            String novaQtd = JOptionPane.showInputDialog("Nova quantidade");
            produtos.remove(itemAtu);
            produtos.add(novoNome + fraseValUni + novoValUni + fraseQtd + novaQtd);
            break;
        }
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 para ver o estoque, 2 para adicionar produto, 3 para excluir ou 4 para atualizar"));
        }
         }  
        
    }
    





    /*public class Produto {
        
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
                
    }
}
    

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
