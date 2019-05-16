package Treinador;

import java.util.Random;

import Item.Item;
import Pokemon.Pokemon;

public class Treinador {
	Random rand = new Random();
	
	private int vivos;
	private int num_pokemons;
	private String name;
	private boolean turn;
	private boolean fuga;
	private boolean selvagem;
	
	private Pokemon[] pokemons = new Pokemon[6];
	private int pokeAtual;
	private Item itens[] = new Item[10];
	private int itemAtual;
	
	public Treinador(int pokemons, String name, boolean selvagem) {
		if(num_pokemons > 6)
			return;
		this.num_pokemons = pokemons;
		this.pokeAtual = 0;
		this.vivos = pokemons;
		this.name= name;
		this.itemAtual = 9;
		this.turn = true;
		this.fuga = false;
		this.selvagem = selvagem;
		
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
				ProxPokemon();
			return true;
		}
		return false;
	}
	
	public void trocaPokemon(int troca){
		this.pokeAtual = troca;
	}
	
	public void ProxPokemon(){
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
	
	public void listaPokemons() {
		Pokemon aux;
		for(int i=0; i<6; i++) {
			aux = pokemons[i];
			if(aux.Hp() != 0)
				System.out.println(i+1+"-"+aux.Nome()+" HP - "+aux.Hp());
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
	
	public boolean CheckFuga() {
		return fuga;
	}
	
	public void Fuga() {
		this.fuga = true;
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
	
	public int numPotions() {
		return itemAtual+1;
	}
	
	public boolean selvagem() {
		return selvagem;
	}
}
