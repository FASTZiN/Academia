
public class Exercicio {
 	private String nome;
 	private String series;
	private String repeticoes;
	
	
	Exercicio(String x_nome, String x_series, String x_repeticoes) {
		this.nome = x_nome;
		this.series = x_series;
		this.repeticoes = x_repeticoes;
	}

	public void imprimir(GerenciadorExs ge) {
		ge.imprimirExs(nome, series, repeticoes);
	}

		
}