package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Calculos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConsultaAlunosController implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	private TextField txtNomeAluno;

	@FXML
	private Button btConsultaAluno;

	@FXML
	public void onTxtNomeAlunoAction() {
	}

	@FXML
	public void onBtConsultaAlunoAction() {
		calculos.cadastraAlunosSalas();
		String nomeAl = txtNomeAluno.getText();
		calculos.consultaAluno(nomeAl);

//		System.out.println(calculo.getSala1turno1());
//		System.out.println(calculo.getSala1turno2());

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
