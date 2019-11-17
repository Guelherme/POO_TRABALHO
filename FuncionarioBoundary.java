package Boundary;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FuncionarioBoundary extends Application{
	private TextField textNome = new TextField();
	private TextField textRG = new TextField();
	private TextField textCPF = new TextField();
	private ComboBox<String> comboFuncao = new ComboBox<String>();
	private ComboBox<String> comboPermissao = new ComboBox<String>();
	private Button BtnSalvar = new Button("Salvar");
	private Button BtnEditar = new Button("Editar");
	private Button BtnExcluir = new Button("Excluir");
	private Button BtnVoltar = new Button("Voltar");



	@Override
	public void start(Stage stage) throws Exception {
		BorderPane Principal = new BorderPane();
		GridPane panel = new GridPane();
		FlowPane buttons = new FlowPane();
		
		//colocando imagem de Fundo
		Image fundo = new Image(getClass().getResourceAsStream("/Imagem/Fundo.jpg"));
		ImageView imgView = new ImageView(fundo);
		Principal.getChildren().add(imgView);
		
		
		ObservableList<String> opcoes = FXCollections.observableArrayList("Ajudante", "Pizzaiolo","Atendente","Gerente");
		ObservableList<String> opcoes1 = FXCollections.observableArrayList("Acesso Total","Acesso Visualização", "Acesso Alteração/Visualização","Acesso a Relatorios");
		
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(75);

		panel.setHgap(10);
		panel.setVgap(10);
		
		panel.getColumnConstraints().addAll(col0, col1);
		
		Principal.setCenter(panel);
		Principal.setBottom(buttons);
		
			
		panel.add(new Label("Nome") , 0, 1);
		panel.add(textNome, 1, 1);
		
		panel.add(new Label ("RG"), 0, 3);
		panel.add(textRG, 1, 3);
		
		panel.add(new Label("CPF"), 0, 5);
		panel.add(textCPF, 1, 5);
		
		panel.add(new Label("Função"), 0, 7);
		panel.add(comboFuncao, 1, 7);
		comboFuncao.setItems(opcoes);
		
		panel.add(new Label("Permissão"), 0, 9);
		panel.add(comboPermissao, 1, 9);
		comboPermissao.setItems(opcoes1);
		
		buttons.getChildren().addAll(BtnSalvar , BtnEditar, BtnExcluir, BtnVoltar);
		buttons.setVgap(20);
		buttons.setHgap(20);
		panel.add(buttons, 0, 17, 2, 1);
		
		//Botao de voltar a tela inicial
				BtnVoltar.setOnAction((a)-> {
					TelaInicial inicial = new TelaInicial();
					try {
						inicial.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

		
		Scene scn = new Scene(Principal, 600, 350);
			
		stage.setScene(scn);
		stage.setTitle("GM Stock - Funcionarios");
		stage.setResizable(false);
		stage.show();
		
	}
	public static void main(String []args){
		launch(args);

			
	}
	

}
