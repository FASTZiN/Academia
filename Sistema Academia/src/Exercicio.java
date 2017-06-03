
public class Exercicio {
 	private String nome;
 	private int series;
	private int repeticoes;

	public Exercicio(String nome, int series, int repeticoes) {
		this.nome = nome;
		this.series = series;
		this.repeticoes = repeticoes;
	}

	void imprimir() {
		System.out.println("Exercicio: " + nome + " Series: " + series + " Rep: " + repeticoes);
	}

	String getNome(){
     	return nome;
	}

	int getSeries(){
		return series;
	}

	int getRepeticoes(){
		return repeticoes;
	}
		
}
