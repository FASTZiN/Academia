

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Aluno implements ActionListener{
	private String nome = "caio";
	private Exercicio[] exercicios = new Exercicio[6];
	private int n;
	//JLabel r;
	
	/*Aluno(JLabel r){
	this.r = r;	
	}*/
	
	void Rotina1(){
	   exercicios[0] = new Exercicio("Supino", 3, 12);
	   exercicios[1] = new Exercicio("Supino Reto", 3, 12);
	   exercicios[2] = new Exercicio("Supino Inclinado", 3, 12);
	   exercicios[3] = new Exercicio("Supino Maquino", 3, 12);
	   exercicios[4] = new Exercicio("Supino c/ Halter", 3, 12);
	   exercicios[5] = new Exercicio("Supino", 3, 12);	
	
	}
	void Rotina2(){
		   exercicios[0] = new Exercicio("Agachamento", 3, 12);
		   exercicios[1] = new Exercicio("XXXXXXXXXX", 3, 12);
		   exercicios[2] = new Exercicio("Inclinado", 3, 12);
		   exercicios[3] = new Exercicio("Supino Maquino", 3, 12);
		   exercicios[4] = new Exercicio("Supino c/ Halter", 3, 12);
		   exercicios[5] = new Exercicio("Supino", 3, 12);	
		
		}
	
	/*void infAluno(){
		r.setText(nome);
	}*/
	
	void imprimir(int n){
		if (n == 1){
			this.Rotina1();
			for(int i =0; i < 6; i++){
				exercicios[i].imprimir();
				System.out.println("--------------------------------------");
			}
		}else{
				if(n == 2){
					this.Rotina2();
					for(int i =0; i < 6; i++){
						exercicios[i].imprimir();
						System.out.println("--------------------------------------");
					}		
		  }
		 }
		}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method st
		//this.infAluno();
		this.imprimir(n);

	}

 }	
