
import java.util.Scanner;
import Controller.Controller;
import Event.Event;
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
			numPoke1 = scanner.nextInt();
			
			System.out.println("Digite o nome do treinador");
			treinador2 = scanner.next();
			System.out.println("Num de pokemons do treinador "+ treinador2);
			numPoke2 = scanner.nextInt();
			
			
			Treinador p1 = new Treinador(numPoke1, treinador1);
			Treinador p2 = new Treinador(numPoke2, treinador2);
			
			rinhaDeGalo p = new rinhaDeGalo(p1, p2);
			
			p.IniciaBatalha();
		
		}else if(acao == 2) {
			
		}else {
			System.out.println("Acao invalida");
		}
	}
}
