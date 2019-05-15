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
		System.out.println("TO AQUI");
		while( ash.CheckPokes() && tresh.CheckPokes() ) {
			Pokemon poke1 = ash.getPokemon();
			Pokemon poke2 = tresh.getPokemon();
			
			System.out.println("Treinador "+ ash.nome() +" esta com o pokemon "+ poke1.Nome() + " com hp "+poke1.Hp()+ " com ataque "+poke1.Ataque()+" prioridade de ataque "+ poke1.Prioridade());
			System.out.println("Treinador "+ ash.nome() +", digite uma acao: 1- Ataque, 2-Troca Pokemon, 3-Fugir da batalha, 4-Usar Poção");
			int acao1 = scanner.nextInt();
			
			System.out.println("------------------------------------------------------------------------------");
			
			System.out.println("Treinador "+ tresh.nome() +" esta com o pokemon "+ poke2.Nome() + " com hp "+poke2.Hp()+ " com ataque "+poke2.Ataque()+" prioridade de ataque "+ poke2.Prioridade());
			
			
			System.out.println("Treinador "+ tresh.nome() +", digite uma acao: 1- Ataque, 2-Troca Pokemon, 3-Fugir da batalha, 4-Usar Poção");
			int acao2 = scanner.nextInt();
			
			
			/*Averiguando se a ação é igual caso contrario é izi*/
			if(acao1 == acao2) {
				
				if(poke1.Prioridade() >= poke2.Prioridade()) {
					long tm = System.currentTimeMillis();
					
					/*AÇÃO DO ASHE*/
					if(acao1 == 1) {
						ataque atck = new ataque(tm, ash, tresh);
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
						ataque atck = new ataque(tm, tresh, ash);
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
						ataque atck = new ataque(tm, tresh, ash);
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
						ataque atck = new ataque(tm, ash, tresh);
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
					ataque atck = new ataque(tm, ash, tresh);
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
					ataque atck = new ataque(tm, tresh, ash);
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
					ataque atck = new ataque(tm, tresh, ash);
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
					ataque atck = new ataque(tm, ash, tresh);
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
		
		public ataque(long eventTime, Treinador atacando, Treinador atacado) {
			super(eventTime);
			
			atacante = atacando;
			this.atacado = atacado;
		}
		
		public void action() {
			Pokemon galoAtacante = atacante.getPokemon();
			
			if( !atacado.Defende(galoAtacante.Ataque()) ){
				System.out.println("O pokemon foi derrotado pelo "+ galoAtacante.Nome());
			}else {
				System.out.println("O pokemon sofreu dano "+ galoAtacante.Ataque() +" pelo "+ galoAtacante.Nome());
			}
			
		}
		
		public String description() {
			return "Esse é o evento de ataque";
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
			return "Esse é o evento de usar item";
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
			return "O treinador trocou de pokemon";
		}
		
	}
}