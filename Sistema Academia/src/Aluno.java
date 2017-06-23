
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
    
    public void imprimirNomeP(){
    	System.out.println(nome + "/"+ matriculaAluno);
    }
    
    public boolean verificarMatricula(String matricula){
    	boolean res = false;
    	if (this.matriculaAluno.equals(matricula)){
    		res = true;}
    	return res;
    }
	public void imprimirTreinamento(int x_treino,ImprimirExs ge){
	treinos[x_treino].imprimirTreino(ge);
	}
	public void criarNovosExs(JFormattedTextField recebe_treino, GerenciadorNovaSerie gt, JButton add, JFormattedTextField qtsExs, JFormattedTextField exs, JFormattedTextField serie, JFormattedTextField repeticoes){
	int x_treino = Integer.parseInt(recebe_treino.getText());
		treinos[x_treino].criarNovosExs(gt, add, qtsExs, exs, serie, repeticoes);	
	}
}

