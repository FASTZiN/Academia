

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
 }