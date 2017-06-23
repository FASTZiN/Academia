import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class criarNovaSerie implements GerenciadorNovaSerie {
	private boolean apertado;
	private int n, e;
	private String exs, serie, rep;
	@Override
	public void criarSerie(Exercicio[] exercicios, JButton add,JFormattedTextField qtsExs, JFormattedTextField p_exs, JFormattedTextField p_serie,
			JFormattedTextField p_rep) {
		
		n = Integer.parseInt(qtsExs.getText());
		
		for(int i = 0; i < n; i++){
			this.exs = p_exs.getText();
			this.serie = p_serie.getText();
			this.rep = p_rep.getText();
		e = i;	
		do{
			add.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent ex) { 
					  exercicios[e] = new Exercicio(exs,serie,rep);					    
					  p_exs.setText(null);
					  p_serie.setText(null);
					  p_rep.setText(null);
					  apertado = true;
					  } 
					} );
			
		}while(apertado == false);
		}
		
	}

}
