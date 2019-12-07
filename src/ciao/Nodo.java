package ciao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nodo {
	
	private Integer dis;
	private Map<Nodo,Integer> nodiAdiacenti;
	private String nome;
	private List<Nodo> percorso;
	private Nodo precedente;
	
	public Nodo getPrecedente() {
		return precedente;
	}

	public void setPrecedente(Nodo precedente) {
		this.precedente = precedente;
	}

	public Nodo(String nome) {
		dis=Integer.MAX_VALUE;
		this.nome=nome;
		nodiAdiacenti=new HashMap<>();
		percorso=new ArrayList<>();
	}
	
	public List<Nodo> getPercorso() {
		return percorso;
	}

	public void setPercorso(List<Nodo> percorso) {
		this.percorso = percorso;
	}
	
	public void addPercorso(Nodo n) {
		percorso.add(n);
	}

	public void addNodiAdi(Nodo n,int distanza) {
		nodiAdiacenti.put(n, distanza);
	}

	public void setDis(Integer dis) {
		this.dis = dis;
	}

	public Integer getDis() {
		return dis;
	}

	public Map<Nodo, Integer> getNodiAdiacenti() {
		return nodiAdiacenti;
	}

	public String getNome() {
		return nome;
	}

}
