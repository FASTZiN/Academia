import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Main extends JFrame implements ActionListener {
	//Definindo algumas "Variaveis"
	private JPanel quadroAluno;
	private JPanel quadroInicio;
	private JPanel quadroProf;
	private JPanel senhaProf;
	private JPanel quadroAddAluno;
	private JFormattedTextField matricula, addNome, addSobrenome;
	private JPasswordField senha;
	private Aluno a;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private int width = 800;
	private int height = 700;
	private String x = null;
	private ImprimirExs imprimir;
	private Professor prof = new Professor();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Main() {
		Treino[] treino_teste = new Treino[2];
		treino_teste[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Desenvolvimento", "5", "5"),
				new Exercicio("Levantamento Terra", "5", "5")});
		treino_teste[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Supino Reto", "5", "5"),
				new Exercicio("Remada Curvada", "5", "5")});
		a = new Aluno("Caio",treino_teste, "00000001");

		//Definindo confgurações JFrame
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);

		//Quadro Inicio
		quadroInicio = new JPanel();
		quadroInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
		quadroInicio.setLayout(null);
		setContentPane(quadroInicio);

		//Quadro Aluno

		quadroAluno = new JPanel();
		quadroAluno.setBorder(new EmptyBorder(5, 5, 5, 5));
		quadroAluno.setLayout(null);
		
		//Quadro Professor
		quadroProf = new JPanel();
		quadroProf.setBorder(new EmptyBorder(5,5,5,5));
		quadroProf.setLayout(null);

		//Quadro Senha
		senhaProf = new JPanel();
		senhaProf.setBorder(new EmptyBorder(5,5,5,5));
		senhaProf.setLayout(null);
		
		//Quadro Add Aluno
		
		quadroAddAluno = new JPanel();
		quadroAddAluno.setBorder(new EmptyBorder(5,5,5,5));
		quadroAddAluno.setLayout(null);
		//Inicializando
		inicio(quadroInicio);

	}

	//DEFININDO GUI INICIAL
	private void inicio(JPanel inicio_quadro) {
		JLabel panel = new JLabel();
		Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
		panel.setIcon(new ImageIcon(img));
		panel.setBounds(268, 119, 263, 237);
		quadroInicio.add(panel);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMatricula.setBounds(259, 444, 123, 30);
		quadroInicio.add(lblMatricula);

		
		matricula = new JFormattedTextField(mask());
		matricula.setBounds(364, 444, 197, 36);
		matricula.setText(null);
		quadroInicio.add(matricula);
		matricula.setColumns(8);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(326, 516, 140, 50);
		quadroInicio.add(btnBuscar);
		btnBuscar.setActionCommand("BUSCAR");
		btnBuscar.addActionListener(this);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.setBounds(width/1000,height/1000,70,20);
		quadroInicio.add(adminBtn);
		adminBtn.setActionCommand("Admin");
		adminBtn.addActionListener(this);
	}

	private MaskFormatter mask() {
		MaskFormatter f = null;
		try {
			f = new MaskFormatter("########");
			f.setValidCharacters("1234567890");
		} catch (java.text.ParseException e) {
			System.err.println("formatter is bad: " + e.getMessage());
			System.exit(-1);
		}

		return f;
	}

	//Definindo GUI ALUNO
	private void pagina_Aluno(JPanel aluno_quadro) {
		JLabel lblNome = new JLabel();
		a.mostrarNome(lblNome);
		lblNome.setBounds(61, 26, 100, 16);
		aluno_quadro.add(lblNome);

		JLabel lblMatricula = new JLabel();
		a.mostrarMatriculaAluno(lblMatricula);
		lblMatricula.setBounds(61, 67, 200, 16);
		aluno_quadro.add(lblMatricula);

		JButton btnTreinoA = new JButton("Treino A");
		btnTreinoA.setBounds(108, 132, 117, 29);
		aluno_quadro.add(btnTreinoA);
		btnTreinoA.setActionCommand("Treino A");
		btnTreinoA.addActionListener(this);

		JButton btnTreinoB = new JButton("Treino B");
		btnTreinoB.setBounds(349, 132, 117, 29);
		aluno_quadro.add(btnTreinoB);
		btnTreinoB.setActionCommand("Treino B");
		btnTreinoB.addActionListener(this);

		JButton btnTreinoC = new JButton("Treino C");
		btnTreinoC.setBounds(588, 132, 117, 29);
		btnTreinoC.setActionCommand("Treino C");
		aluno_quadro.add(btnTreinoC);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(349, 626, 117, 29);
		aluno_quadro.add(btnVoltar);
		btnVoltar.setActionCommand("VOLTAR");
		btnVoltar.addActionListener(this);


		textArea = new JTextArea(5, 300);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		textArea.setBounds(150, 200, 500, 400);
		aluno_quadro.add(textArea);
		aluno_quadro.add(scrollPane);

	}
	
	//GUI Senha Prof
		private void senhaProf(JPanel senhaProf){
			JLabel panel = new JLabel();
			Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
			panel.setIcon(new ImageIcon(img));
			panel.setBounds(268, 119, 263, 237);
			senhaProf.add(panel);
			
			JLabel lblSenha = new JLabel("Senha: ");
			lblSenha.setBounds(width/2-150,height/2,200,30);
			senhaProf.add(lblSenha);

			this.senha = new JPasswordField();
			senha.setBounds(width/2-100,height/2,200,30);
			senhaProf.add(senha);

			JButton btnSenha = new JButton("Enter");
			btnSenha.setBounds(width/2+100,height/2,100,30);
			senhaProf.add(btnSenha);
			btnSenha.setActionCommand("Enter");
			btnSenha.addActionListener(this);

			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(349, 626, 117, 29);
			senhaProf.add(btnVoltar);
			btnVoltar.setActionCommand("VOLTAR");
			btnVoltar.addActionListener(this);

		}

		//Definindo GUI PROF
		private void paginaProf(JPanel quadroProf) {
			JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
			lblAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblAdministrador.setBounds(261, 57, 257, 41);
			quadroProf.add(lblAdministrador);
			
			JLabel lblSelecioneAOpao = new JLabel("SELECIONE A OPÇÃO DESEJADA A SEGUIR:");
			lblSelecioneAOpao.setBounds(65, 226, 300, 16);
			quadroProf.add(lblSelecioneAOpao);
			
			JButton btnAdiocionarAluno = new JButton("ADICIONAR ALUNO");
			btnAdiocionarAluno.setBounds(129, 312, 185, 29);
			btnAdiocionarAluno.setActionCommand("ADICIONAR ALUNO");
			quadroProf.add(btnAdiocionarAluno);
			btnAdiocionarAluno.addActionListener(this);
			
			JButton btnRemoverAluno = new JButton("REMOVER ALUNO");
			btnRemoverAluno.setBounds(129, 435, 185, 29);
			quadroProf.add(btnRemoverAluno);
			
			JButton btnCriarTreino = new JButton("CRIAR TREINO");
			btnCriarTreino.setBounds(436, 312, 185, 29);
			quadroProf.add(btnCriarTreino);
			
			JButton btnAlterarTreino = new JButton("ALTERAR TREINO");
			btnAlterarTreino.setBounds(436, 435, 185, 29);
			quadroProf.add(btnAlterarTreino);
			
			JButton btnListaDeAlunos = new JButton("LISTA DE ALUNOS");
			btnListaDeAlunos.setBounds(289, 538, 185, 29);
			quadroProf.add(btnListaDeAlunos);
			
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(349, 626, 117, 29);
			quadroProf.add(btnVoltar);
			btnVoltar.setActionCommand("VOLTAR");
			btnVoltar.addActionListener(this);
		}
		
		//Definindo GUI Add ALUNO
		
		private void paginaAddAluno(JPanel quadroAddAluno){
			JLabel lblAdcionandoUmAluno = new JLabel("ADICIONANDO UM ALUNO");
			lblAdcionandoUmAluno.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			lblAdcionandoUmAluno.setBounds(215, 135, 334, 32);
			quadroAddAluno.add(lblAdcionandoUmAluno);
			
			JLabel lblParaAdiconarUm = new JLabel("PARA ADICONAR UM ALUNO AO SISTEMA, BASTA COLOCAR O NOME, SOBRENOME DO NOVO ALUNO");
			lblParaAdiconarUm.setBounds(73, 226, 648, 16);
			quadroAddAluno.add(lblParaAdiconarUm);
			
			JLabel lblNome = new JLabel("NOME:");
			lblNome.setBounds(138, 341, 61, 16);
			quadroAddAluno.add(lblNome);
			
			addNome = new JFormattedTextField();
			addNome.setBounds(187, 336, 477, 26);
			quadroAddAluno.add(addNome);
			addNome.setColumns(10);
			
			JLabel lblSobrenome = new JLabel("SOBRENOME:");
			lblSobrenome.setBounds(138, 434, 81, 16);
			quadroAddAluno.add(lblSobrenome);
			
			addSobrenome = new JFormattedTextField();
			addSobrenome.setBounds(231, 429, 433, 26);
			quadroAddAluno.add(addSobrenome);
			addSobrenome.setColumns(10);
			
			JButton btnNewButton = new JButton("ADICIONAR");
			btnNewButton.setBounds(336, 619, 117, 29);
			quadroAddAluno.add(btnNewButton);
			
			JLabel lblAoClicarEm = new JLabel("AO CLICAR EM ADICIONAR, UMA MENSAGEM SERÁ EXIBIDA INFORMANDO SE O ALUNO FOI ADIOCIONADO COM SUCESSO");
			lblAoClicarEm.setBounds(20, 531, 763, 32);
			quadroAddAluno.add(lblAoClicarEm);
		}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		x = matricula.getText();

		if(cmd.equals("BUSCAR") && !a.verificarMatricula(x)){

			JOptionPane.showMessageDialog(new JFrame(), "Aluno não matriculado!");
			System.out.println(matricula.getText());
			matricula.setText(null);
		}
		
		else if(cmd.equals("BUSCAR") && a.verificarMatricula(x)){
			
			setContentPane(quadroAluno);
			invalidate();
			validate();
			this.pagina_Aluno(quadroAluno);
			System.out.println(matricula.getText());
			matricula.setText(null);
			//System.out.println(a.verificarMatricula(x));
			
		}

		else if(cmd.equals("Treino A")){
			textArea.setText(null);
			imprimir = new ImprimirExs(textArea);
			a.imprimirTreinamento(0,imprimir);

		}

		else if(cmd.equals("Treino B")){
			textArea.setText(null);
			imprimir = new ImprimirExs(textArea);
			a.imprimirTreinamento(1, imprimir);
		}
		else if(cmd.equals("Treino C")){
			textArea.setText(null);
			imprimir = new ImprimirExs(textArea);
			a.imprimirTreinamento(2, imprimir);
		}
		else if(cmd.equals("Admin")){
			setContentPane(senhaProf);
			invalidate();
			validate();
			this.senhaProf(senhaProf);
		}
		else if(cmd.equals("ADICIONAR ALUNO")){
			setContentPane(quadroAddAluno);
			invalidate();
			validate();
			this.paginaAddAluno(quadroAddAluno);
		}
		else if(cmd.equals("Enter")){
			char[] input = senha.getPassword();
			if(isPasswordCorrect(input)) {
				setContentPane(quadroProf);
				invalidate();
				validate();
				this.paginaProf(quadroProf);
			} else{JOptionPane.showMessageDialog(new JPanel(),"SENHA ERRADA");}
			
		}

		else if (cmd.equals("VOLTAR")) {
			setContentPane(quadroInicio);
			invalidate();
			validate();
		}

	}

	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { 'a', 'b', 'c', 'd', '1', '2', '3', '4' };

		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals (input, correctPassword);
		}

		//Zero out the password.
		Arrays.fill(correctPassword,'0');

		return isCorrect;
	}
}