package modelo;

import java.util.HashMap;
import java.util.Map;

public class BancoDados {
	private Map<Integer, Produto> produtos = new HashMap<>();
	private Map<String, FormaDePagamento> formasDePagamento = new HashMap<>();
	private Map<Integer, ItemEstoque> itensEstoque = new HashMap<>();
	
	private static BancoDados bd = new BancoDados();

	private BancoDados() {
		// Simula a tabela produtos
		Produto arroz = new Produto("Arroz", 5); 
		produtos.put(1, arroz);
		
		Produto feijao = new Produto("Feijão", 10);
		produtos.put(2, feijao);
		
		Produto milho = new Produto("Milho", 3);
		produtos.put(3, milho);
		
		Produto sal = new Produto("Sal", 2);
		produtos.put(4, sal);
		
		Produto acucar = new Produto("Açucar", 7); 
		produtos.put(5, acucar);
		
		Produto cafe = new Produto("Café", 12);
		produtos.put(6, cafe);
		
		Produto mel = new Produto("Mel", 20.5);
		produtos.put(7, mel);
		
		Produto pao = new Produto("Pão", 10);
		produtos.put(8, pao);
		
		// Simula a tabela de formas de pagamento
		PagamentoComDesconto dinheiro = new PagamentoComDesconto();
		dinheiro.setDescricao("Dinheiro");
		dinheiro.setTaxaDesconto(10);
		
		PagamentoComDesconto debito = new PagamentoComDesconto();
		debito.setDescricao("Débito");
		debito.setTaxaDesconto(5);
		
		PagamentoComJuros credito = new PagamentoComJuros();
		credito.setDescricao("Crédito");
		credito.setTaxaJuros(0);
		
		formasDePagamento.put("di", dinheiro);
		formasDePagamento.put("cd", debito);
		formasDePagamento.put("cc", credito);
		
		
		itensEstoque.put(1, new ItemEstoque(2, arroz));
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
	
	public ItemEstoque selectItemEstoque(Integer codigo){
		if (!this.itensEstoque.containsKey(codigo)) {
			return new ItemEstoque(0, null);
		}
		
		return this.itensEstoque.get(codigo);
	}
}
