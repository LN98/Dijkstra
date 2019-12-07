package ciao;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Grafo g=new Grafo();
		
		
		Scanner s=new Scanner(System.in);
		//creazione del grafo
		System.out.println("quanti nodi hai?");
		int nNodi=s.nextInt();
		for(int i=1;i<=nNodi;i++) {
			char c =(char)(64+i);
			Nodo n=new Nodo(Character.toString(c));
			g.addNodo(n);
		}
		
		int nArchi;
		for(int i=0;i<g.getNodi().size();i++) {
			do {
			System.out.println("quanti archi partono da nodo "+g.getNodi().get(i).getNome()+"?");
			nArchi=s.nextInt();
			}while(nArchi<0||nArchi>nNodi-1);
			for(int j=1;j<=nArchi;j++) {
				System.out.println("destinazione?");
				String des=s.next();
				
				Nodo nDes=null;
				for(int k=0;k<g.getNodi().size();k++) {
					if(g.getNodi().get(k).getNome().equalsIgnoreCase(des)) {
						nDes=g.getNodi().get(k);
					}
				}
				
				System.out.println("distanza?");
				int disArc=s.nextInt();
				g.getNodi().get(i).addNodiAdi(nDes, disArc);
			}
		}
		
		
		//nodo iniziale
		
		System.out.println("Nodo iniziale?");
		String ini=s.next();
		Nodo iniziale=null;
		for(int k=0;k<g.getNodi().size();k++) {
			if(g.getNodi().get(k).getNome().equalsIgnoreCase(ini)) {
				iniziale=g.getNodi().get(k);
			}
		}
		iniziale.setDis(0);
		iniziale.setPrecedente(null);
		
		
		//applicazione del algoritmo
		Algoritmo arg=new Algoritmo(g,iniziale);
		arg.algoritmo();
		arg.aggPercorso();

		for (int i = 0; i < g.getNodi().size(); i++) {
			System.out.print(g.getNodi().get(i).getNome() + " ");
			if (g.getNodi().get(i).getPercorso().size() != 0) {
				for (int k = g.getNodi().get(i).getPercorso().size()-1; k >=0; k--) {
					System.out.print(g.getNodi().get(i).getPercorso().get(k).getNome());
				}
			} else {
				System.out.print("iniziale");
			}
			System.out.println(" "+g.getNodi().get(i).getDis());

		}

	}

}
