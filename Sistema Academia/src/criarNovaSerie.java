import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class criarNovaSerie implements GerenciadorNovaSerie {
	private boolean apertado;
	private int n;
	private int e = 0;
	private String exs, serie, rep;
	imprimirSystemOut ge = new imprimirSystemOut();
	
	@Override
	public void criarSerie(Exercicio[] exercicios,JFormattedTextField qtsExs, JFormattedTextField p_exs, JFormattedTextField p_serie, JFormattedTextField p_rep) {
		n = Integer.parseInt(qtsExs.getText());
		if(e < n){
			this.exs = p_exs.getText();
			this.serie = p_serie.getText();
			this.rep = p_rep.getText();
		 exercicios[e] = new Exercicio(exs,serie,rep);
		 System.out.println(e);
		 exercicios[e].imprimir(ge);
		  p_exs.setText(null);
		  p_serie.setText(null);
		  p_rep.setText(null);
		  e = e + 1;
		}
		else{JOptionPane.showMessageDialog(new JFrame(), "Treino cadastrado com sucesso");}
	}
}
