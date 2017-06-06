
public class Exercicio {
 	private String nome;
 	private String series;
	private String repeticoes;

	public Exercicio(String nome, String series, String repeticoes) {
		this.nome = nome;
		this.series = series;
		this.repeticoes = repeticoes;
	}

	public String imprimir() {
		return "Exercicio: " + nome + "\nSeries: " + series + "\nReps: " + repeticoes + "\n################";
	}
		
}