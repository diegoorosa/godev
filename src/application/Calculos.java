package application;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class Calculos implements Serializable {

	public Calculos() {
		super();
	}

	private static final long serialVersionUID = 1L;

	Map<String, String> sala1turno1 = new HashMap<>();
	Map<String, String> sala2turno1 = new HashMap<>();
	Map<String, String> sala1turno2 = new HashMap<>();
	Map<String, String> sala2turno2 = new HashMap<>();
	Map<String, String> sala1Cafe = new HashMap<>();
	Map<String, String> sala2Cafe = new HashMap<>();

	public static String[] salasEventos = new String[2];
	public static int[] salasEventosLotacao = new int[2];
	public static String[] salasCafes = new String[2];
	int[] salasCafesLotacao = new int[2];
	int m = 0;
	int n;
	int q;
	int p = 2;
	public static String[] alunos;

	public void cadastroAlunoQuantidade(Integer q) {
		alunos = new String[q];
		this.q = q;
	}// cadastroAlunoQuantidade

	public void cadastroAlunoNome(String nome) {
		alunos[this.m] = nome;
		this.m++;
	}// cadastroAlunoNome

	public void cadastraSala1(String nome, Integer lotacao) {
		salasEventos[0] = nome;
		salasEventosLotacao[0] = lotacao;
	}// cadastraSala1

	public void cadastraSala2(String nome, Integer lotacao) {
		salasEventos[1] = nome;
		salasEventosLotacao[1] = lotacao;
	}// cadastraSala2

	public void cadastraCafe1(String nome, Integer lotacao) {
		salasCafes[0] = nome;
		salasCafesLotacao[0] = lotacao;
	}// cadastraCafe1

	public void cadastraCafe2(String nome, Integer lotacao) {
		salasCafes[1] = nome;
		salasCafesLotacao[1] = lotacao;
	}// cadastraCafe2

	public void cadastraAlunosSalas() {
		// cadastro salas alunos 1a etapa
		if (alunos == null) {
			Alerts.showAlert("Falta de Cadastro", "Você não cadastrou nenhum aluno", null, AlertType.WARNING);
		}
		for (int i = 0; i < alunos.length; i++) {
			if (i % 2 == 0) {
				sala1turno1.put(alunos[i], salasEventos[0]);
				sala1Cafe.put(alunos[i], salasCafes[0]);
			} else {
				sala2turno1.put(alunos[i], salasEventos[1]);
				sala2Cafe.put(alunos[i], salasCafes[1]);
			} // if else
		} // for
			// cadastro salas alunos 2a etapa
		for (int i = 0; i < alunos.length; i++) {
			if (i % 2 == 0) {
				sala1turno2.put(alunos[i], salasEventos[1]);
			} else if (i % 2 == 1) {
				sala2turno2.put(alunos[i], salasEventos[0]);
			} // if else
		} // for
	}

	public void consultaAluno(String nome) {
		String nomeAluno = nome;
		if (salasEventos[0] == null) {
			Alerts.showAlert("Consulta Aluno", nome, "Você não cadastrou nenhuma sala!", AlertType.WARNING);
		} else if (salasCafes[0] == null) {
			Alerts.showAlert("Consulta Aluno", nome, "Você não cadastrou nenhuma cafeteria!", AlertType.WARNING);
		} else {
			if (sala1turno1.containsKey(nomeAluno)) {
				Alerts.showAlert("Consulta Aluno", nomeAluno,
						"Na Primeira Etapa o aluno " + nomeAluno + " estará na Sala " + sala1turno1.get(nomeAluno)
								+ "\n" + "Na segunda etapa o aluno " + nomeAluno + " estará na Sala "
								+ sala1turno2.get(nomeAluno) + "\n" + "Sala do Café de " + nomeAluno + ": "
								+ sala1Cafe.get(nomeAluno),
						AlertType.INFORMATION);
			} else if (sala2turno1.containsKey(nomeAluno)) {
				Alerts.showAlert("Consulta Aluno", nomeAluno,
						"Na Primeira Etapa o aluno " + nomeAluno + " estará na Sala " + sala2turno1.get(nomeAluno)
								+ "\n" + "Na segunda etapa o aluno " + nomeAluno + " estará na Sala "
								+ sala2turno2.get(nomeAluno) + "\n" + "Sala do Café de " + nomeAluno + ": "
								+ sala2Cafe.get(nomeAluno),
						AlertType.INFORMATION);
			} else {
				Alerts.showAlert("Consulta Aluno", nome, "Aluno não existe", AlertType.WARNING);
			} // if else
		} // if else
	}// consultaAluno

	public void consultaSala(String nome) {
		String nomeSala = nome;
		String key1 = "";
		String key2 = "";
		String key3 = "";
		String key4 = "";
		if (sala1turno1.containsValue(nomeSala)) {
			Set<String> keys = sala2turno2.keySet();
			for (String key : keys) {
				key3 += key + ", ";
			} // for
			Alerts.showAlert("Consulta Sala", "Segunda Etapa", "Alunos: " + key3, AlertType.INFORMATION);
		} else if (sala2turno1.containsValue(nomeSala)) {
			Set<String> keys = sala1turno2.keySet();
			for (String key : keys) {
				key4 += key + ", ";
			} // for
			Alerts.showAlert("Consulta Sala", "Segunda Etapa", "Alunos: " + key4, AlertType.INFORMATION);
		} else {
			Alerts.showAlert("Consulta Sala", "Sala não existe", null, AlertType.INFORMATION);
		} // if else

		if (sala1turno1.containsValue(nomeSala)) {
			Set<String> keys = sala1turno1.keySet();
			for (String key : keys) {
				key1 += key + ", ";
			} // for
			Alerts.showAlert("Consulta Sala", "Primeira Etapa", "Alunos: " + key1, AlertType.INFORMATION);
		} else if (sala2turno1.containsValue(nomeSala)) {
			Set<String> keys = sala2turno2.keySet();
			for (String key : keys) {
				key2 += key + ", ";
			} // for
			Alerts.showAlert("Consulta Sala", "Primeira Etapa", "Alunos: " + key2, AlertType.INFORMATION);
		}
	}// consultaSala

	public void consultaCafe(String nome) {
		String nomeCafeteria = nome;
		String key1 = "";
		String key2 = "";
		if (sala1Cafe.containsValue(nomeCafeteria)) {
			Set<String> keys = sala1Cafe.keySet();
			for (String key : keys) {
				key1 += key + ", ";
			} // for
			Alerts.showAlert("Consulta Cafeteria", nomeCafeteria, "Alunos: " + key1, AlertType.INFORMATION);
		} else if (sala2Cafe.containsValue(nomeCafeteria)) {
			Set<String> keys = sala2Cafe.keySet();
			for (String key : keys) {
				key2 += key + ", ";
			} // for
			Alerts.showAlert("Consulta Cafeteria", nomeCafeteria, "Alunos: " + key2, AlertType.INFORMATION);
		} else {
			Alerts.showAlert("Consulta Cafeteria", "Cafeteria não existe", null, AlertType.INFORMATION);
		} // if else
	}// consultaCafe
}
