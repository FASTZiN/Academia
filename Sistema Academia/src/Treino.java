import javax.swing.JFormattedTextField;

/**
 * Created by Marcel Fernandes on 6/2/2017.
 */
public class Treino{
    private int n;
    Exercicio[] exercicios = new Exercicio[n];
    
    Treino(Exercicio[] exercicios){
        this.exercicios = exercicios;
    }
    
    void imprimirTreino(ImprimirExs ge){
    	for(Exercicio e : exercicios){
    	if(e != null)
    		e.imprimir(ge);
    	}
    }
    
    void criarNovosExs(GerenciadorNovaSerie gt, JFormattedTextField qtsExs, JFormattedTextField exs, JFormattedTextField serie, JFormattedTextField repeticoes){
    	
    	n = Integer.parseInt(qtsExs.getText());
		//exercicios = new Exercicio[n];
    	
    	gt.criarSerie(exercicios,qtsExs, exs, serie, repeticoes);
    }
 }