package Pokemon;

import java.util.Random;

import rinhaDeGalo.rinhaDeGalo.ataque;

public class Pokemon {
	Random rand = new Random();
	private int hp_atual, hp , prioridade;
	private Ataque[] ataques = new Ataque[4];
	private String nome;
	
	public Pokemon() {
		this.hp=hp_atual=geraHp();
		
		
		/*Gerando os ataques*/
		for(int i=0; i<4; i++)
			this.ataques[i] = new Ataque(geraAtaque(), GeraNomeAtaque(), geraPrio() );
		
		this.nome = GetName();
	}
	
	private String GetName() {
		String nome = "";
		String nomes[] = {"squ", "mu", "blas", "meta", "fo" ,"pepe","char","ka", "fo","pid", "bee", "rat", "fear", "ek", "pik",
							"ni", "gi", "lu", "ta", "mach", "n", "to",  "da", "se"};
		
		for(int i=0 ; i < 3 ; i++)
			nome += nomes[rand.nextInt(23)];
		
		return nome;
	}
	
	private int geraHp() {
		return rand.nextInt(150);
	}
	
	private int geraAtaque() {
		return rand.nextInt(50);
	}
	
	private String GeraNomeAtaque() {
		String nome = "";
		String primario[] = {"Soco ", "Punho ", "Chute ", "Cabeçada ", "Rajada ", "Galo "};
		String secundario[] = {"de fogo", " de água", "de raio", "de grama", "de vento", "de terra"};
		
		nome += primario[rand.nextInt(5)] + secundario[rand.nextInt(5)];
		
		return nome;
	}
	
	private int geraPrio() {
		return rand.nextInt(150);
	}
	
	public void Cura(int cura) {
		
		if(hp_atual + cura >= hp)
			hp_atual = hp;
		else
			hp_atual += cura;
			
	}
	
	public boolean Defende(int ataque) {
		
		if(hp_atual - ataque <= 0) {
			hp_atual = 0;
			return false;
		}
		hp_atual -= ataque;
		return true;
	}
	
	public String Nome() {
		return nome;
	}
	
	public void ListaAtaques() {
		for(int i=0; i<4; i++) {
			System.out.println(ataques[i].nome()+" Dano - "+ataques[i].Dano()+ " Prio - "+ ataques[i].nome());
		}
	}
	
	public int Ataque(int seleciona) {
		return ataques[seleciona].Dano();
	}
	
	public int Hp() {
		return hp_atual;
	}
	
	public int Prioridade() {
		return prioridade;
	}

}
