/**
 * Created by Marcel Fernandes on 6/6/2017.
 */
public class Professor {
    Aluno a;
    public void addAluno(String nome, String matricula){
        a = new Aluno(null, nome, matricula);
    }
}
