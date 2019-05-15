
import java.util.Scanner;
import Controller.Controller;
import Event.Event;
import Pokemon.Pokemon;
import Treinador.Treinador;
import rinhaDeGalo.rinhaDeGalo;

public class Batalha {
	public static void main(String[] args) {
		Treinador p1 = new Treinador(6, "Juca");
		Treinador p2 = new Treinador(6, "Juquinha");
		rinhaDeGalo p = new rinhaDeGalo(p1, p2);
		p.IniciaBatalha();
	}
}
