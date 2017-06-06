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
	private JFormattedTextField matricula;
	private JPasswordField senha;
	private Aluno a;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private int width = 800;
	private int height = 700;

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

		a = new Aluno(new Treino[2], "Caio", "00000001");
		a.setTreino(0, new Treino('A', new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Supino Reto", "5", "5"),
				new Exercicio("Remada Curvada", "5", "5")}));
		a.setTreino(1, new Treino('B', new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Desenvolvimento", "5", "5"),
				new Exercicio("Levantamento Terra", "5", "5")}));


		//Definindo confgurações JFrame
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);

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


		//Inicializando
		inicio(quadroInicio);

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

	//DEFININDO GUI INICIAL
	private void inicio(JPanel inicio_quadro) {
		JLabel panel = new JLabel();
		///Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
		//panel.setIcon(new ImageIcon(img));
		panel.setBounds(268, 119, 263, 237);
		quadroInicio.add(panel);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMatricula.setBounds(259, 444, 123, 30);
		quadroInicio.add(lblMatricula);

		matricula = new JFormattedTextField(mask());
		matricula.setBounds(364, 444, 197, 36);
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


	//Definindo GUI ALUNO
	private void pagina_Aluno(JPanel aluno_quadro) {
		JLabel lblNome = new JLabel("Nome: " + a.getNome());
		lblNome.setBounds(61, 26, 100, 16);
		aluno_quadro.add(lblNome);

		JLabel lblMatricula = new JLabel("Matricula: " + a.getMatriculaAluno());
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
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(61, 26, 100, 16);
		quadroProf.add(lblNome);

		JTextField nome = new JTextField();
		nome.setBounds(150,28,100,16);
		quadroProf.add(nome);

		JLabel lblMatricula = new JLabel("Matricula: ");
		lblMatricula.setBounds(61, 67, 200, 16);
		quadroProf.add(lblMatricula);

		JTextField txtMatricula = new JTextField();
		txtMatricula.setBounds(150,70,100,16);
		quadroProf.add(txtMatricula);

		JButton addAluno = new JButton("Add Aluno");
		addAluno.setBounds(100,150,100,30);
		quadroProf.add(addAluno);
		addAluno.setActionCommand("Add Aluno");
		addAluno.addActionListener(this);


		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(349, 626, 117, 29);
		quadroProf.add(btnVoltar);
		btnVoltar.setActionCommand("VOLTAR");
		btnVoltar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("BUSCAR")) {
			if (matricula.getText().equals(a.getMatriculaAluno())) {
				setContentPane(quadroAluno);
				invalidate();
				validate();
				this.pagina_Aluno(quadroAluno);
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Aluno não matriculado!");
			}

		}

		else if(cmd.equals("Treino A")){
			textArea.setText(null);
			textArea.setText(a.getTreino(0));

		}

		else if(cmd.equals("Treino B")){
			textArea.setText(null);
			textArea.setText(a.getTreino(1));
		}

		else if(cmd.equals("Admin")){
			setContentPane(senhaProf);
			invalidate();
			validate();
			this.senhaProf(senhaProf);
		}

		else if(cmd.equals("Enter")){
			char[] input = senha.getPassword();
			if(isPasswordCorrect(input)) {
				setContentPane(quadroProf);
				invalidate();
				validate();
				this.paginaProf(quadroProf);
			}
		}

		else if(cmd.equals("Add Aluno")){

		}

		else if (cmd.equals("VOLTAR")) {
			setContentPane(quadroInicio);
			invalidate();
			validate();
			this.inicio(quadroInicio);
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
