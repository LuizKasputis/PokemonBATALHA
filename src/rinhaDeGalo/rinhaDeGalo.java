package rinhaDeGalo;

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
		Scanner scanner = new Scanner(System.in);
		Controller control = new Controller();
		int acao1, atack1=0, acao2, atack2=0;
		
		while( ash.CheckPokes() && tresh.CheckPokes() ) {
			Pokemon poke1 = ash.getPokemon();
			Pokemon poke2 = tresh.getPokemon();
			
			System.out.println("------------------------------------------------------------------------------");
			
			System.out.println("Treinador "+ ash.nome() +" POKEMONS VIVOS "+ash.Vivos()+" Pokemon atual\n"+poke1.Nome() + " HP - "+poke1.Hp() +"\n                    ATACKS");
			poke1.ListaAtaques();
			System.out.println("\nTreinador "+ ash.nome() +", digite uma acao: 1- Ataque, 2-Troca Pokemon, 3-Fugir da batalha, 4-Usar Poção");
			acao1 = scanner.nextInt();
			if(acao1 == 1) {
				System.out.println("Selecione o ATCK");
				atack1 = scanner.nextInt();
				atack1--;
			}
			System.out.println("------------------------------------------------------------------------------");
			
			System.out.println("Treinador "+ tresh.nome() +" POKEMONS VIVOS "+tresh.Vivos()+" Pokemon atual\n"+poke2.Nome() + " HP - "+poke2.Hp()+"\n                    ATACKS");
			poke2.ListaAtaques();
			System.out.println("\nTreinador "+ tresh.nome() +", digite uma acao: 1- Ataque, 2-Troca Pokemon, 3-Fugir da batalha, 4-Usar Poção");
			acao2 = scanner.nextInt();
			if(acao2 == 1) {
				System.out.println("Selecione o ATCK");
				atack2 = scanner.nextInt();
				atack2--;
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
						TrocaPokemon troca = new TrocaPokemon(tm, ash);
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
						TrocaPokemon troca = new TrocaPokemon(tm, tresh);
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
						TrocaPokemon troca = new TrocaPokemon(tm, tresh);
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
						TrocaPokemon troca = new TrocaPokemon(tm, ash);
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
			}else if(acao1 > acao2) {
				long tm = System.currentTimeMillis();
				
				/*AÇÃO DO ASHE*/
				if(acao1 == 1) {
					ataque atck = new ataque(tm, ash, tresh, atack1);
					control.addEvent(atck);
				}else if(acao1 == 2) {
					TrocaPokemon troca = new TrocaPokemon(tm, ash);
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
					TrocaPokemon troca = new TrocaPokemon(tm, tresh);
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
					TrocaPokemon troca = new TrocaPokemon(tm, tresh);
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
					TrocaPokemon troca = new TrocaPokemon(tm, ash);
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
		
		if(ash.CheckPokes()) {
			System.out.println("O treinador "+ ash.nome() +" venceu a partida");
		}else {
			System.out.println("O treinador "+ tresh.nome() +" venceu a partida");
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
			
			if( atacado.Defende(galoAtacante.Ataque(seleciona)) ){
				System.out.println("O pokemon foi derrotado pelo "+ galoAtacante.Nome());
			}else {
				System.out.println("O pokemon "+galoAtacante.Nome()+" usou o ataque "+galoAtacante.NomeAtack(seleciona)+" e causou "+galoAtacante.Ataque(seleciona)+" de dano no "+ galoAtacado.Nome());
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
			return "ITEM EVENT";
		}
		
	}
	
	public class Fuga extends Event{
		private Treinador bundao;
		
		public Fuga(long eventTime, Treinador cuzao) {
			super(eventTime);
			
			bundao = cuzao;
			
		}
		
		public void action() {
			System.out.println("RUN FOREST RUNNNNNN");
		}
		
		public String description() {
			return "Esse é o evento de fugir";
		}
		
	}
	
	public class TrocaPokemon extends Event {
		private Treinador trocador;
		
		public TrocaPokemon(long evenTime, Treinador trocando) {
			super(evenTime);
			trocador = trocando;
		}
		
		public void action() {
			trocador.trocaPokemon();
		}
		
		public String description() {
			return "O "+ trocador.nome() +"trocou de pokemon para o"+ trocador.getPokemon().Nome();
		}
		
	}
}