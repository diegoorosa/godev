package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Calculos;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroSalasController implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	private TextField txtNomeSala1;
	@FXML
	private TextField txtLotacaoSala1;
	@FXML
	private TextField txtNomeSala2;
	@FXML
	private TextField txtLotacaoSala2;

	@FXML
	public void onTxtNomeSala1() {
	}

	@FXML
	public void onTxtLotacaoSala1() {
	}

	@FXML
	public void onTxtNomeSala2() {
	}

	@FXML
	public void onTxtLotacaoSala2() {
	}

	@FXML
	private Button btAdicionaSala1;
	@FXML
	private Button btAdicionaSala2;

	Integer lotacao = 0;

	@FXML
	public void onBtAdicionaSala1Action() {
		String nomeSala1 = txtNomeSala1.getText();
		Integer lotacaoSala1 = Integer.parseInt(txtLotacaoSala1.getText());
		calculos.cadastraSala1(nomeSala1, lotacaoSala1);
		lotacao += lotacaoSala1;
	}

	@FXML
	public void onBtAdicionaSala2Action() {
		String nomeSala2 = txtNomeSala2.getText();
		Integer lotacaoSala2 = Integer.parseInt(txtLotacaoSala2.getText());
		calculos.cadastraSala2(nomeSala2, lotacaoSala2);
		lotacao += lotacaoSala2;
		if (lotacao < Calculos.alunos.length) {
			Alerts.showAlert("Cadastro de Salas", "Lugares insuficientes nas salas",
					"Cadastre menos alunos ou salas maiores", AlertType.WARNING);
		}
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
