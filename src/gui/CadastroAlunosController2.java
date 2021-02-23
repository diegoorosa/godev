package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Calculos;
import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CadastroAlunosController2 implements Initializable {

	Calculos calculos = new Calculos();

	@FXML
	Button btSalvarQuantidade;

	@FXML
	public void onBtSalvarQuantidade() {
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		calculos.cadastroAlunoQuantidade(quantidade);
		loadView("/gui/CadastroAlunos.fxml");
	}

	@FXML
	private TextField txtQuantidade;

	@FXML
	public void onTxtQuantidadeAction() {
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
