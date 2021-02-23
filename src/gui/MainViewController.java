package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuCadastroAlunos;

	@FXML
	private MenuItem menuCadastroSalas;

	@FXML
	private MenuItem menuCadastroCafes;

	@FXML
	public void onMenuCadastroAlunosAction() {
		loadView("/gui/CadastroAlunos2.fxml");
	}

	@FXML
	public void onMenuCadastroSalasAction() {
		loadView("/gui/CadastroSalas.fxml");
	}

	@FXML
	public void onMenuCadastroCafesAction() {
		loadView("/gui/CadastroCafeterias.fxml");
	}

	@FXML
	private MenuItem menuConsultaAlunos;

	@FXML
	private MenuItem menuConsultaSalas;

	@FXML
	private MenuItem menuConsultaCafes;

	@FXML
	public void onMenuConsultaAlunosAction() {
		loadView("/gui/ConsultaAlunos.fxml");
	}

	@FXML
	public void onMenuConsultaSalasAction() {
		loadView("/gui/ConsultaSalas.fxml");
	}

	@FXML
	public void onMenuConsultaCafesAction() {
		loadView("/gui/ConsultaCafeterias.fxml");
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
