package modelo;

import java.util.ArrayList;

public class Estoque {
	private ArrayList<ItemEstoque> itens = new ArrayList<>();

	public ArrayList<ItemEstoque> getItens() {
		return itens;
	}

	public void addItens(ItemEstoque item) {
		this.itens.add(item);
	}
}