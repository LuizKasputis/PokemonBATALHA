package Mapa;

import java.util.Random;

public class Mapa {
	private static int lin=25, col=100;
	private char mapa[][] = new char[lin][col];
	private int nowC, nowL;
	private char before;
	

	Random rand = new Random();
	
	public Mapa() {
		for(int i=0; i<lin; i++) {
			for(int j=0; j<col; j++) {
				int aux = rand.nextInt(100);
				if(aux < 20) {
					mapa[i][j]=  '#';
				}else {
					mapa[i][j] = '.';
				}
			}
		}
		before = mapa[0][0];
		mapa[0][0] = 'A';
	}
	
	public void printaMapa(){
		for(int i=0; i<lin; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(mapa[i][j]);
			}
		System.out.println();
		}
	}
	
	public void Andar(char mov) {
		if(mov == 'w' || mov == 'W') {
			if(nowL - 1 >= 0) {
				mapa[nowL][nowC] = before;
				nowL--;
				before = mapa[nowL][nowC];
				mapa[nowL][nowC] = 'A';
			}
			return;
		}else if(mov == 'd' || mov == 'D') {
			if(nowC + 1 < col) {
				mapa[nowL][nowC] = before;
				nowC++;
				before = mapa[nowL][nowC];
				mapa[nowL][nowC] = 'A';
			}
			return;
		}else if(mov == 's' || mov == 'S') {
			if(nowL + 1 < lin) {
				mapa[nowL][nowC] = before;
				nowL++;
				before = mapa[nowL][nowC];
				mapa[nowL][nowC] = 'A';
			}
			return;
		}else if(mov == 'a' || mov == 'A'){
			if(nowC - 1 >= 0) {
				mapa[nowL][nowC] = before;
				nowC--;
				before = mapa[nowL][nowC];
				mapa[nowL][nowC] = 'A';
			}
			return;
		}
		
		System.out.println("Movimento invalido");
	}
	
	public boolean grama() {
		if(before == '#') {
			int aux = rand.nextInt(100);
			if(aux < 20) {
				return true;
			}
			return false;
		}else {
			return false;
		}
	}
	
}
