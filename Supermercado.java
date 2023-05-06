package supermercado;
import java.util.*;



public class Supermercado {


		 private Map<String, Produto> estoque;
		    
		    public Supermercado() {
		        estoque = new HashMap<String, Produto>();
		    }
		    
		    public void adicionarProduto(String nome, double preco, int quantidade) {
		        Produto produto = new Produto(nome, preco, quantidade);
		        estoque.put(nome, produto);
		    }
		    
		    public boolean verificarEstoque(String nome, int quantidade) {
		        Produto produto = estoque.get(nome);
		        return (produto != null && produto.getQuantidade() >= quantidade);
		    }
		    
		    public boolean realizarPedido(List<Item> itens, String formaPagamento) {
		        double valorTotal = 0;
		        for (Item item : itens) {
		            String nome = item.getNome();
		            int quantidade = item.getQuantidade();
		            Produto produto = estoque.get(nome);
		            if (produto == null || produto.getQuantidade() < quantidade) {
		                System.out.println("Produto " + nome + " indisponível em estoque.");
		                return false;
		            }
		            valorTotal += produto.getPreco() * quantidade;
		            produto.removerQuantidade(quantidade);
		        }
		        if (formaPagamento.equals("dinheiro")) {
		            System.out.println("Pagamento em dinheiro. Valor total: R$" + valorTotal);
		        } else if (formaPagamento.equals("cheque")) {
		            System.out.println("Pagamento em cheque. Valor total: R$" + valorTotal);
		        } else if (formaPagamento.equals("cartao")) {
		            System.out.println("Pagamento em cartão. Valor total: R$" + valorTotal);
		        } else {
		            System.out.println("Forma de pagamento inválida.");
		            return false;
		        }
		        return true;
		    }
		    
		    public static void main(String[] args) {
		        Supermercado supermercado = new Supermercado();
		        supermercado.adicionarProduto("Arroz", 10.0, 20);
		        supermercado.adicionarProduto("Feijão", 8.0, 15);
		        supermercado.adicionarProduto("Macarrão", 5.0, 30);
		        
		        List<Item> itens = new ArrayList<Item>();
		        itens.add(new Item("Arroz", 2));
		        itens.add(new Item("Feijão", 3));
		        itens.add(new Item("Macarrão", 1));
		        supermercado.realizarPedido(itens, "dinheiro");
		    }
		    
	}


