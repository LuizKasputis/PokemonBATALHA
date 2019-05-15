package Pokemon;

public class Ataque {
	private int dano, prio;
	private String nome;
	public Ataque(int dano, String nome, int prio) {
		this.dano = dano;
		this.nome = nome;
		this.prio = prio;
	}
	
	public int Dano() {
		return dano;
	}
	
	public String nome() {
		return nome;
	}
	
	public int prioridade() {
		return prio;
	}
}
