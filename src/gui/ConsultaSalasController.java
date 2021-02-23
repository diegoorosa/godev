package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Calculos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConsultaSalasController implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	private TextField txtNomeSala;

	@FXML
	private Button btConsultaSala;

	@FXML
	public void onTxtNomeSalaAction() {
	}

	@FXML
	public void onBtConsultaSalaAction() {
		calculos.cadastraAlunosSalas();
		String nomeSa = txtNomeSala.getText();
		calculos.consultaSala(nomeSa);

//		System.out.println(calculo.getSala1turno1());
//		System.out.println(calculo.getSala1turno2());

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
