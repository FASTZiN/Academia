import javax.swing.JButton;
import javax.swing.JFormattedTextField;

/**
 * Created by Marcel Fernandes on 6/2/2017.
 */
public class Treino{
    Exercicio[] exercicios;
    
    Treino(Exercicio[] exercicios){
        this.exercicios = exercicios;
    }
    
    void imprimirTreino(ImprimirExs ge){
    	for(int i = 0; i < exercicios.length; i++){
    		exercicios[i].imprimir(ge);
    	}
    }
    
    void criarNovosExs(GerenciadorNovaSerie gt,JButton add,JFormattedTextField qtsExs, JFormattedTextField exs, JFormattedTextField serie, JFormattedTextField repeticoes){
    	gt.criarSerie(exercicios, add,qtsExs, exs, serie, repeticoes);
    }
 }