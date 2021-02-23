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

public class CadastroCafeteriasController implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	private TextField txtNomeCafe1;
	@FXML
	private TextField txtLotacaoCafe1;
	@FXML
	private TextField txtNomeCafe2;
	@FXML
	private TextField txtLotacaoCafe2;

	@FXML
	public void onTxtNomeCafe1() {
	}

	@FXML
	public void onTxtLotacaoCafe1() {
	}

	@FXML
	public void onTxtNomeCafe2() {
	}

	@FXML
	public void onTxtLotacaoCafe2() {
	}

	@FXML
	private Button btAdicionaCafe1;
	@FXML
	private Button btAdicionaCafe2;

	Integer lotacao = 0;

	@FXML
	public void onBtAdicionaCafe1Action() {
		String nomeCafe1 = txtNomeCafe1.getText();
		Integer lotacaoCafe1 = Integer.parseInt(txtLotacaoCafe1.getText());
		calculos.cadastraCafe1(nomeCafe1, lotacaoCafe1);
		lotacao += lotacaoCafe1;
	}

	@FXML
	public void onBtAdicionaCafe2Action() {
		String nomeCafe2 = txtNomeCafe2.getText();
		Integer lotacaoCafe2 = Integer.parseInt(txtLotacaoCafe2.getText());
		calculos.cadastraCafe2(nomeCafe2, lotacaoCafe2);
		lotacao += lotacaoCafe2;
		if (lotacao < Calculos.alunos.length) {
			Alerts.showAlert("Cadastro de Cafeterias", "Lugares insuficientes nas cafeerias",
					"Cadastre menos alunos ou cafeterias maiores", AlertType.WARNING);
		}
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
