package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Calculos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroAlunosController implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	private Button btSalvarAlunos;

	@FXML
	public void onBtSalvarAlunosAction() {
		String nomeAluno = txtNomeAlunos.getText();
		calculos.cadastroAlunoNome(nomeAluno);
		txtNomeAlunos.setText("");
	}

	@FXML
	private TextField txtNomeAlunos;

	@FXML
	private TextField txtQuantidade;

	@FXML
	public void onTxtNomeAlunosAction() {
	}

	@FXML
	public void onTxtQuantidadeAction() {
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
