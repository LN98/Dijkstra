package ciao;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Nodo> nodi;
	
	public Grafo() {
		nodi=new ArrayList<>();
	}
	
	public void addNodo(Nodo e) {
		nodi.add(e);
	}

	public List<Nodo> getNodi() {
		return nodi;
	}
}
