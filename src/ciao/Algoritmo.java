package ciao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algoritmo {

	private Grafo g;
	private Nodo iniziale;

	public Algoritmo(Grafo g,Nodo iniziale) {
		this.g = g;
		this.iniziale=iniziale;
		
	}

	private void analisi(Nodo n, Map<Nodo, Integer> rest) {
		if (n.getNodiAdiacenti().size() != 0) {
			List<Nodo> nodi = new ArrayList<>(n.getNodiAdiacenti().keySet());
			int newDis;// distanza di nodo d'arrivo + arco
			for (int i = 0; i < nodi.size(); i++) {
				if (rest.containsKey(nodi.get(i))) {
					newDis = n.getDis() + n.getNodiAdiacenti().get(nodi.get(i));
						if (nodi.get(i).getDis() > newDis) {// se disIniziale è maggiore del nuovo cambiare
							nodi.get(i).setDis(newDis);
							nodi.get(i).setPrecedente(n);
						}
					}
				}
			
		}

	}
	
	public void aggPercorso() {
		Nodo p;
		for(int i=1;i<g.getNodi().size();i++) {
			p=g.getNodi().get(i);
			while(p.getPrecedente()!=null) {
				g.getNodi().get(i).addPercorso(p);
				p=p.getPrecedente();
			}
			g.getNodi().get(i).addPercorso(iniziale);
		}
		
	}

	public void algoritmo() {
		Map<Nodo, Integer> res=new HashMap<>();
		for (int i = 0; i < g.getNodi().size(); i++) {
			res.put(g.getNodi().get(i), g.getNodi().get(i).getDis());
		}
		
		
		while (res.size()!=0) {
			
			if(res.size()==g.getNodi().size()) {
				analisi(iniziale,res);
				res.remove(iniziale);
			} 
			else {
				for(int i=0;i<g.getNodi().size();i++) {
					if(res.containsKey(g.getNodi().get(i))) {
						res.put(g.getNodi().get(i), g.getNodi().get(i).getDis());
					}
				}
				List<Nodo> ni=new ArrayList<>(res.keySet());
				int min = Integer.MAX_VALUE;
				Nodo nodoMin = null;
				for (int i = 0; i < res.size(); i++) {
					if (res.get(ni.get(i)) < min) {
						
						min = res.get(ni.get(i));
						nodoMin = ni.get(i);
					}
				}
				analisi(nodoMin, res);

				res.remove(nodoMin);
			
			}
		}
	}

}
