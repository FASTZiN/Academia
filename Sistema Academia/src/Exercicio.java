import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Exercicio {
 private String nomeExerc;
 private int series;
 private int repeticoes;
	
     Exercicio(String nomeExerc, int series, int repeticoes){
		this.nomeExerc = nomeExerc;
		this.series = series;
		this.repeticoes = repeticoes;		
	}
	void imprimir(){
		System.out.println("Exercicio:"+ nomeExerc +" Series: "+ series +" Rep:"+ repeticoes);
	}
		
}
