package modelo;

public class ItemEstoque {
	private int quantidade;
	private Produto produto;
	
	public ItemEstoque(int quantidade, Produto p) {
		this.quantidade = quantidade;
		this.produto = p;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
