package Treinador;

import java.util.Random;

import Item.Item;
import Pokemon.Pokemon;

public class Treinador {
	Random rand = new Random();
	
	private int vivos;
	private int num_pokemons;
	private Pokemon[] pokemons = new Pokemon[6];
	private int pokeAtual;
	private String name;
	private boolean turn;
	
	private Item itens[] = new Item[10];
	private int itemAtual;
	
	public Treinador(int pokemons, String name) {
		if(num_pokemons > 6)
			return;
		this.num_pokemons = pokemons;
		this.pokeAtual = 0;
		this.vivos = pokemons;
		this.name= name;
		this.turn = true;
		CriaPokemons();
		CriaItens();
	}
	
	private void CriaItens() {
		for(int i=0; i<10; i++)
			itens[i] = new Item();
	}
	
	private void CriaPokemons() {
		for(int i=0; i<num_pokemons; i++)
			pokemons[i] =  new Pokemon();
	}
	
	public boolean Defende(int dano) {
		if(!pokemons[pokeAtual].Defende(dano)){
			vivos--;
			if(vivos != 0)
				trocaPokemon();
			return true;
		}
		return false;
	}
	
	
	public void trocaPokemon(){
		if(pokeAtual == num_pokemons - 1)
			pokeAtual = 0;
		else
			pokeAtual++;
		while(pokemons[pokeAtual].Hp() == 0) {
			pokeAtual++;
			if(pokeAtual == num_pokemons - 1)
				pokeAtual = 0;
		}
	}
	
	public void UsaItem() {
		
		if(itens[itemAtual].checkItem()) {
			System.out.println("A poção de "+ itens[itemAtual].valorCura() +" hp foi usada ");
			int cura = itens[itemAtual].usarItem();
			pokemons[pokeAtual].Cura(cura);
			itemAtual++;
		}else {
			System.out.println("Não existem poções suficientes ");
		}
		
	}
	
	public boolean CheckPokes() {
		if(vivos != 0)
			return true;
		else
			return false;
	}
	
	public String nome() {
		return name;
	}
	
	public Pokemon getPokemon() {
		return pokemons[pokeAtual];
	}
	
	public int Vivos() {
		return vivos;
	}
	
	public void MudaTurn(boolean turn) {
		this.turn = turn;
	}
	
	public boolean turn() {
		return turn;
	}
}
