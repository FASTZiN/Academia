import javax.swing.JTextArea;

public class ImprimirExs implements GerenciadorExs {
	JTextArea i;
	
	ImprimirExs(JTextArea i){
		this.i=i;
	}
	public void imprimirExs(String nome, String serie, String repeticao) {
		i.setText("Exercicio: " + nome + "\nSeries: " + serie + "\nReps: " + repeticao + "\n################");
		System.out.println("Exercicio: " + nome + "\nSeries: " + serie + "\nReps: " + repeticao + "\n################");
	}
}
