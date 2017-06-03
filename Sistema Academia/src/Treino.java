/**
 * Created by Marcel Fernandes on 6/2/2017.
 */
public class Treino{
    Exercicio[] exercicios;
    char c;

    public Treino(char c, Exercicio[] exercicios){
        this.exercicios = exercicios;
        this.c = c;
    }

    public Exercicio[] getExercicios(){
        return exercicios;
    }

}
