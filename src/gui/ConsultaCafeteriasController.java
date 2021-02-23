package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Calculos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConsultaCafeteriasController implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	private TextField txtNomeCafe;

	@FXML
	private Button btConsultaCafe;

	@FXML
	public void onTxtNomecafeAction() {
	}

	@FXML
	public void onBtConsultaCafeAction() {
		calculos.cadastraAlunosSalas();
		String nomeCa = txtNomeCafe.getText();
		calculos.consultaCafe(nomeCa);

//		System.out.println(calculo.getSala1turno1());
//		System.out.println(calculo.getSala1turno2());

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
