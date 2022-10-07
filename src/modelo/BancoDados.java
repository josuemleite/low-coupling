package modelo;

import java.util.HashMap;
import java.util.Map;

// Singleton

public class BancoDados {
	private Map<Integer, Produto> produtos = new HashMap<>();
	private Map<String, FormaDePagamento> formasDePagamento = new HashMap<>();
	private Map<Integer, ItemEstoque> itensEstoque = new HashMap<>();
	
	private static BancoDados bd = new BancoDados();

	private BancoDados() {
		// Simula a tabela produtos
		Produto arroz = new Produto("Arroz", 5); 
		produtos.put(1, arroz);
		
		Produto feijao = new Produto("Feij�o", 10);
		produtos.put(2, feijao);
		
		Produto milho = new Produto("Milho", 3);
		produtos.put(3, milho);
		
		Produto sal = new Produto("Sal", 2);
		produtos.put(4, sal);
		
		Produto acucar = new Produto("A��car", 7); 
		produtos.put(5, acucar);
		
		Produto cafe = new Produto("Caf�", 12);
		produtos.put(6, cafe);
		
		Produto mel = new Produto("Mel", 20.5);
		produtos.put(7, mel);
		
		Produto pao = new Produto("P�o", 10);
		produtos.put(8, pao);
		
		// Simula a tabela de formas de pagamento
		PagamentoComDesconto dinheiro = new PagamentoComDesconto();
		dinheiro.setDescricao("Dinheiro");
		dinheiro.setTaxaDesconto(10);
		
		PagamentoComDesconto debito = new PagamentoComDesconto();
		debito.setDescricao("D�bito");
		debito.setTaxaDesconto(5);
		
		PagamentoComJuros credito = new PagamentoComJuros();
		credito.setDescricao("Cr�dito");
		credito.setTaxaJuros(0);
		
		formasDePagamento.put("di", dinheiro);
		formasDePagamento.put("cd", debito);
		formasDePagamento.put("cc", credito);
		
		
		itensEstoque.put(1, new ItemEstoque(5, arroz));
		itensEstoque.put(2, new ItemEstoque(3, feijao));
		itensEstoque.put(3, new ItemEstoque(10, milho));
		itensEstoque.put(4, new ItemEstoque(1, sal));
		itensEstoque.put(5, new ItemEstoque(1, acucar));
		itensEstoque.put(6, new ItemEstoque(1, cafe));
		itensEstoque.put(7, new ItemEstoque(1, mel));
		itensEstoque.put(8, new ItemEstoque(1, pao));
	}
	
	public static BancoDados getInstancia() {
		return bd;
	}
	
	public Produto selectProduto(Integer codigo){
		if (!this.produtos.containsKey(codigo)) {
			return new Produto("Produto Inválido", 0);
		}
		
		return this.produtos.get(codigo);
	}
	
	public FormaDePagamento selectFormaDePagamento(String forma){
		return formasDePagamento.get(forma);
	}
	
	public Integer selectQuantidadeItemEstoque(Integer codProduto){
		ItemEstoque ie = itensEstoque.get(codProduto);
		
		if (ie != null) {
			int quantidadeItem = ie.getQuantidade();
			return quantidadeItem;
		}
		
		return 0;
	}
	
	public void diminuiQuantidadeItemEstoque(Integer codProduto, int quantidade) {
		ItemEstoque ie = itensEstoque.get(codProduto);
		
		if (ie == null) {
			return;
		}
		
		int qtdeAtual = ie.getQuantidade();
		ie.setQuantidade(qtdeAtual - quantidade);
	}
}
