import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Aluno {

    Treino[] treinos;
    String nome;
    String matriculaAluno;

    public Aluno(Treino[] treinos, String nome, String matriculaAluno) {
        this.treinos = treinos;
        this.nome = nome;
        this.matriculaAluno = matriculaAluno;
    }

    public String getTreino(int x){
        String[] exs = new String[treinos[x].exercicios.length];
        for(int i = 0; i < treinos[x].exercicios.length; i++){
            exs[i] = treinos[x].exercicios[i].imprimir();
        }
        String res = String.join("\n",exs);

        return res;
    }

    public void mostrarNome(JLabel r) {
        r.setText("Nome: "+ nome);
    }

    public void mostrarMatriculaAluno(JLabel r) {
        r.setText("Matricula: "+ matriculaAluno);
    }
    
    public boolean verificarMatricula(String matricula){
    	boolean res = false;
    	if (matricula.equals(this.matriculaAluno))
    		res = true;
    	
    	return res;
    }
    
    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setTreino(int i, Treino t){
        this.treinos[i] = t;
    }

    public void setTreinos(Treino[] treinos) {
        this.treinos = treinos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }
}

