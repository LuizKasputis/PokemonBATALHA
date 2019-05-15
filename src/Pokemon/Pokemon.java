package Pokemon;

import java.util.Random;

public class Pokemon {
	Random rand = new Random();
	private int hp_atual, hp , prioridade;
	private int ataques[] = new int[4];
	private int ataque_atual;
	private String nome;
	
	public Pokemon() {
		this.hp=hp_atual=geraHp();
		
		for(int i=0; i<4; i++)
			this.ataques[i] = geraAtaque();
		
		this.prioridade = geraPrio();
		ataque_atual = 0;
		this.nome = GetName();
	}
	
	private String GetName() {
		String nome = " ";
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
	
	public void MudaAtaque() {
		if(ataque_atual != 3)
			ataque_atual++;
		else
			ataque_atual = 0;
	}
	
	public String Nome() {
		return nome;
	}
	
	public int Ataque() {
		return ataques[ataque_atual];
	}
	
	public int Hp() {
		return hp_atual;
	}
	
	public int Prioridade() {
		return prioridade;
	}

}
