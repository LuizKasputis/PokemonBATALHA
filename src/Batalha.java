
import java.util.Scanner;
import Controller.Controller;
import Event.Event;
import Mapa.Mapa;
import Pokemon.Pokemon;
import Treinador.Treinador;
import rinhaDeGalo.rinhaDeGalo;

public class Batalha {
	public static void main(String[] args) {
		int acao;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Deseja 1 - simular uma batalha pokemon ou 2 - andar pelo mapa?");
		acao = scanner.nextInt();
		
		if(acao == 1) {
			String treinador1, treinador2;
			int numPoke1, numPoke2;
			
			
			System.out.println("Digite o nome do primeiro treinador");
			treinador1 = scanner.next();
			System.out.println("Num de pokemons do treinador "+ treinador1);
			numPoke1 = numPokes();
			
			System.out.println("Digite o nome do treinador");
			treinador2 = scanner.next();
			System.out.println("Num de pokemons do treinador "+ treinador2);
			numPoke2 = numPokes();
			
			
			Treinador p1 = new Treinador(numPoke1, treinador1, false);
			Treinador p2 = new Treinador(numPoke2, treinador2, false);
			
			rinhaDeGalo p = new rinhaDeGalo(p1, p2);
			
			p.IniciaBatalha();
		
		}else if(acao == 2) {
			Mapa mapa = new Mapa();
			
			/*Criando Treinador*/
			String treinador1;
			int numPoke1;
			
			System.out.println("Digite o nome do primeiro treinador");
			treinador1 = scanner.next();
			System.out.println("Num de pokemons do treinador "+ treinador1);
			numPoke1 = scanner.nextInt();
			
			Treinador ash = new Treinador(numPoke1, treinador1, false);
			
			/*Aqui acontece a simulação de andar no mapa, a chance de aparecer um pokemon é de 20% quando se está num arbusto*/
			/*A simulação só acaba quando quando acaba os pokemons do treinador*/
			while(ash.CheckPokes()) {
				mapa.printaMapa();
				
				System.out.println("Digite seu movimento AWSD");
				
				char aux= scanner.next().charAt(0);
				mapa.Andar(aux);
				
				if(mapa.grama()) {
					Treinador selvagem = new Treinador(1,"", true);
					System.out.println("Wild pokemon appears! It's "+ selvagem.getPokemon().Nome()+" with HP -"+selvagem.getPokemon().Hp());
					rinhaDeGalo selva = new rinhaDeGalo(ash, selvagem);
					
					selva.IniciaBatalha();
					
				}
			}
		}else {
			System.out.println("Acao invalida");
		}
	}
	
	
	public static int numPokes(){
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
