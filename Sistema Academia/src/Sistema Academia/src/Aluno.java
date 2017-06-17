
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Aluno extends Pessoa{
    private Treino[] treinos;
    private String matriculaAluno;
    
    public Aluno(String nome,Treino[] treinos, String matriculaAluno) {
    	super(nome);
        this.treinos = treinos;
        this.matriculaAluno = matriculaAluno;
    }

    public void mostrarNome(JLabel r) {
        r.setText("Nome: "+ nome);
    }

    public void mostrarMatriculaAluno(JLabel r) {
        r.setText("Matricula: "+ matriculaAluno);
    }
    
    public void criarTreino(){
    	
    }
    
    public boolean verificarMatricula(String matricula){
    	boolean res = false;
    	if (matricula.equals(this.matriculaAluno))
    		res = true;
    	
    	return res;
    }
    
	public void imprimirTreinamento(int x_treino,ImprimirExs ge){
	treinos[x_treino].imprimirTreino(ge);
	}
}

