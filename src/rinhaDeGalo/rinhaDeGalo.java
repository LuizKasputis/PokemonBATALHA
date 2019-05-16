package rinhaDeGalo;

import java.util.Random;
import java.util.Scanner;

import Controller.Controller;
import Event.Event;
import Pokemon.Pokemon;
import Treinador.Treinador;

public class rinhaDeGalo {
	private Treinador ash;
	private Treinador tresh;
	
	public rinhaDeGalo(Treinador ash, Treinador tresh) {
		this.ash = ash;
		this.tresh = tresh;
	}
	
	public void IniciaBatalha() {
		
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		Controller control = new Controller();
		int acao1, atack1=0, acao2, atack2=0, troca1=0, troca2=0;
		
		while( ash.CheckPokes() && tresh.CheckPokes() && !ash.CheckFuga() && !tresh.CheckFuga()) {
			Pokemon poke1 = ash.getPokemon();
			Pokemon poke2 = tresh.getPokemon();
			ash.MudaTurn(true);
			tresh.MudaTurn(true);
			
			System.out.println("------------------------------------------------------------------------------");
			
			System.out.println("Treinador "+ ash.nome() +" POKEMONS VIVOS "+ash.Vivos()+"\nNUM potions "+ash.numPotions()+" EFECT 40 HP\nPokemon atual "+poke1.Nome() + " HP - "+poke1.Hp() +"\n                    ATACKS");
			poke1.ListaAtaques();
			System.out.println("\nTreinador "+ ash.nome() +", digite uma acao: 1- Ataque, 2-Troca Pokemon, 3-Fugir da batalha, 4-Usar Poção");
			
			acao1 = acao();
			
			if(acao1 == 1) {
				System.out.println("Selecione o ATCK");
				atack1 = atack();
				atack1--;
			}
			
			if(acao1 == 2) {
				ash.listaPokemons();
				System.out.println("Selecione o Pokemon");
				troca1 = troca();
				troca1--;
			}
			
			System.out.println("------------------------------------------------------------------------------");
			if( !tresh.selvagem() ) {
				
				System.out.println("Treinador "+ tresh.nome() +" POKEMONS VIVOS "+tresh.Vivos()+"\nNUM potions "+ash.numPotions()+" EFECT 40 HP\nPokemon atual "+poke2.Nome() + " HP - "+poke2.Hp()+"\n                    ATACKS");
				poke2.ListaAtaques();
				System.out.println("\nTreinador "+ tresh.nome() +", digite uma acao: 1- Ataque, 2-Troca Pokemon, 3-Fugir da batalha, 4-Usar Poção");
				acao2 = acao();
				
				if(acao2 == 1) {
					System.out.println("Selecione o ATCK");
					atack2 = atack();
					atack2--;
				}
				
				if(acao2 == 2) {
					tresh.listaPokemons();
					System.out.println("Selecione o Pokemon");
					troca2 = troca();
					troca2--;
				}
				
			}else {
				acao2 = 1;
				atack2 = rand.nextInt(4);
			}
			
			
			System.out.println("------------------------------------------------------------------------------");
			
			/*Averiguando se a ação é igual caso contrario é izi*/
			if(acao1 == acao2) {
				
				if(poke1.Prioridade() >= poke2.Prioridade()) {
					long tm = System.currentTimeMillis();
					
					/*AÇÃO DO ASHE*/
					if(acao1 == 1) {
						ataque atck = new ataque(tm, ash, tresh, atack1);
						control.addEvent(atck);
					}else if(acao1 == 2) {
						TrocaPokemon troca = new TrocaPokemon(tm, ash, troca1);
						control.addEvent(troca);
					}else if(acao1 == 3) {
						Fuga fuga= new Fuga(tm, ash);
						control.addEvent(fuga);
					}else if(acao1 == 4){
						Usar use= new Usar(tm, ash);
						control.addEvent(use);
					}
					
					/*AÇÃO DO TRESH*/
					if(acao2 == 1) {
						ataque atck = new ataque(tm, tresh, ash, atack2);
						control.addEvent(atck);
					}else if(acao2 == 2) {
						TrocaPokemon troca = new TrocaPokemon(tm, tresh, troca2);
						control.addEvent(troca);
					}else if(acao2 == 3) {
						Fuga fuga= new Fuga(tm, tresh);
						control.addEvent(fuga);
					}else if(acao2 == 4){
						Usar use= new Usar(tm, tresh);
						control.addEvent(use);
					}
					
				}else {
					long tm = System.currentTimeMillis();
					
					/*Ação Tresh*/
					if(acao2 == 1) {
						ataque atck = new ataque(tm, tresh, ash, atack2);
						control.addEvent(atck);
					}else if(acao2 == 2) {
						TrocaPokemon troca = new TrocaPokemon(tm, tresh, troca2);
						control.addEvent(troca);
					}else if(acao2 == 3) {
						Fuga fuga= new Fuga(tm, tresh);
						control.addEvent(fuga);
					}else if(acao2 == 4){
						Usar use= new Usar(tm, tresh);
						control.addEvent(use);
					}
					
					/*Ação do Ash*/
					if(acao1 == 1) {
						ataque atck = new ataque(tm, ash, tresh, atack1);
						control.addEvent(atck);
					}else if(acao1 == 2) {
						TrocaPokemon troca = new TrocaPokemon(tm, ash, troca1);
						control.addEvent(troca);
					}else if(acao1 == 3) {
						Fuga fuga= new Fuga(tm, ash);
						control.addEvent(fuga);
					}else if(acao1 == 4){
						Usar use= new Usar(tm, ash);
						control.addEvent(use);
					}
					
					
				}
			/*Caso da acão ser prioridade maior q a outra*/
			}else if(acao1 < acao2) {
				long tm = System.currentTimeMillis();
				
				/*AÇÃO DO ASHE*/
				if(acao1 == 1) {
					ataque atck = new ataque(tm, ash, tresh, atack1);
					control.addEvent(atck);
				}else if(acao1 == 2) {
					TrocaPokemon troca = new TrocaPokemon(tm, ash, troca1);
					control.addEvent(troca);
				}else if(acao1 == 3) {
					Fuga fuga= new Fuga(tm, ash);
					control.addEvent(fuga);
				}else if(acao1 == 4){
					Usar use= new Usar(tm, ash);
					control.addEvent(use);
				}
				
				/*AÇÃO DO TRESH*/
				if(acao2 == 1) {
					ataque atck = new ataque(tm, tresh, ash, atack2);
					control.addEvent(atck);
				}else if(acao2 == 2) {
					TrocaPokemon troca = new TrocaPokemon(tm, tresh, troca2);
					control.addEvent(troca);
				}else if(acao2 == 3) {
					Fuga fuga= new Fuga(tm, tresh);
					control.addEvent(fuga);
				}else if(acao2 == 4){
					Usar use= new Usar(tm, tresh);
					control.addEvent(use);
				}
				
			/*Caso da acão ser prioridade menor q a outra*/
			}else {
				
				long tm = System.currentTimeMillis();
				
				/*Ação Tresh*/
				if(acao2 == 1) {
					ataque atck = new ataque(tm, tresh, ash, atack2);
					control.addEvent(atck);
				}else if(acao2 == 2) {
					TrocaPokemon troca = new TrocaPokemon(tm, tresh, troca2);
					control.addEvent(troca);
				}else if(acao2 == 3) {
					Fuga fuga= new Fuga(tm, tresh);
					control.addEvent(fuga);
				}else if(acao2 == 4){
					Usar use= new Usar(tm, tresh);
					control.addEvent(use);
				}
				
				/*Ação do Ash*/
				if(acao1 == 1) {
					ataque atck = new ataque(tm, ash, tresh, atack1);
					control.addEvent(atck);
				}else if(acao1 == 2) {
					TrocaPokemon troca = new TrocaPokemon(tm, ash, troca1);
					control.addEvent(troca);
				}else if(acao1 == 3) {
					Fuga fuga= new Fuga(tm, ash);
					control.addEvent(fuga);
				}else if(acao1 == 4){
					Usar use= new Usar(tm, ash);
					control.addEvent(use);
				}
			}
			
			control.run();
		}
		
		if(ash.CheckFuga() || tresh.CheckFuga()) {
			if(!ash.CheckFuga()) {
				System.out.println("O treinador "+ ash.nome() +" venceu a partida");
			}else {
				System.out.println("O treinador "+ tresh.nome() +" venceu a partida");
			}
		}else {
			if(ash.CheckPokes()) {
				System.out.println("O treinador "+ ash.nome() +" venceu a partida");
			}else {
				System.out.println("O treinador "+ tresh.nome() +" venceu a partida");
			}
		}
	}
	
	public class ataque extends Event{
		private Treinador atacante;
		private Treinador atacado;
		private int seleciona;
		
		public ataque(long eventTime, Treinador atacando, Treinador atacado, int seleciona) {
			super(eventTime);
			
			atacante = atacando;
			this.atacado = atacado;
			this.seleciona = seleciona;
			
		}
		
		public void action() {
			Pokemon galoAtacante = atacante.getPokemon();
			Pokemon galoAtacado = atacado.getPokemon();
			
			if( atacante.turn() ) {
				if( atacado.Defende(galoAtacante.Ataque(seleciona)) ){
					System.out.println("O pokemon "+galoAtacante.Nome()+" usou o ataque "+galoAtacante.NomeAtack(seleciona)+" e derrotou "+ galoAtacante.Nome());
					atacado.MudaTurn(false);
				}else {
					System.out.println("O pokemon "+galoAtacante.Nome()+" usou o ataque "+galoAtacante.NomeAtack(seleciona)+" e causou "+galoAtacante.Ataque(seleciona)+" de dano no "+ galoAtacado.Nome());
				}
			}else {
				System.out.println(galoAtacante.Nome()+" foi derrotado e não fez nenhuma ação esse turno");
			}
			
		}
		
		public String description() {
			return "ATACK EVENT";
		}
		
	}
	
	public class Usar extends Event{
		private Treinador usado;
		
		public Usar(long eventTime, Treinador usando) {
			super(eventTime);
			usado = usando;	
		}
		
		public void action() {
			usado.UsaItem();
		}
		
		public String description() {
			return "EVENT item";
		}
		
	}
	
	public class Fuga extends Event{
		private Treinador bundao;
		
		public Fuga(long eventTime, Treinador cuzao) {
			super(eventTime);
			
			bundao = cuzao;
			
		}
		
		public void action() {
			bundao.Fuga();
		}
		
		public String description() {
			return "RUN FOREST RUNNNNNN, treinador "+bundao.nome()+" meteu a fuga";
		}
		
	}
	
	public class TrocaPokemon extends Event {
		private Treinador trocador;
		private int troca;
		
		public TrocaPokemon(long evenTime, Treinador trocando, int troca) {
			super(evenTime);
			trocador = trocando;
			this.troca = troca;
		}
		
		public void action() {
			trocador.trocaPokemon(troca);
		}
		
		public String description() {
			return "O "+ trocador.nome() +" trocou de pokemon para o "+ trocador.getPokemon().Nome();
		}
		
	}
	
	public int acao() {
		int acao1;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			acao1 = scanner.next().charAt(0);
			if(acao1 <= '4' && acao1 >= '1')
				return acao1 - '0';
			else
				System.out.println("ACAO INVALIDA REPITA O COMANDO");
		}
	}
	
	public int atack() {
		int acao1;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			acao1 = scanner.next().charAt(0);
			if(acao1 <= '4' && acao1 >= '1')
				return acao1 - '0';
			else
				System.out.println("ACAO INVALIDA REPITA O COMANDO");
		}
	}
	
	public int troca() {
		int acao1;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			acao1 = scanner.next().charAt(0);
			if(acao1 <= '6' && acao1 >= '1')
				return acao1 - '0';
			else
				System.out.println("ACAO INVALIDA REPITA O COMANDO");
		}
	}
}