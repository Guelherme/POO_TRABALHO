package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FornecedorBoundary extends Application {
	private TextField txtCodigo = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtCep = new TextField();
	private TextField txtRua = new TextField();
	private TextField txtNumero = new TextField();
	private TextField txtCidade = new TextField();
	
	private Button btnConcluir = new Button("Concluir Cadastro");
	private Button btnAlterar = new Button("  Alterar Cadastro");
	private Button btnExcluir = new Button("  Excluir Cadastro");
	private Button btnVoltar = new Button("  Voltar");

	

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panPrincipal = new BorderPane();
		GridPane panCampos = new GridPane();
		FlowPane panBotoes = new FlowPane();
		
		//colocando imagem de Fundo
		Image fundo = new Image(getClass().getResourceAsStream("/Imagem/Fundo.jpg"));
		ImageView imgView = new ImageView(fundo);
		panPrincipal.getChildren().add(imgView);
		
		panPrincipal.setCenter(panCampos);
		panPrincipal.setBottom(panBotoes);
		
		
		panCampos.add(new Label("Codigo Fornecedor"),  0, 0);
		panCampos.add(txtCodigo, 1, 0);
		panCampos.add(new Label("Nome"), 0, 1);
		panCampos.add(txtNome, 1, 1);
		panCampos.add(new Label("CEP"), 0, 2);
		panCampos.add(txtCep, 1, 2);
		panCampos.add(new Label("Rua"), 0, 3);
		panCampos.add(txtRua, 1, 3);
		panCampos.add(new Label("Numero"), 2, 3);
		panCampos.add(txtNumero, 3, 3);
		panCampos.add(new Label("Cidade"), 0, 4);
		panCampos.add(txtCidade, 1, 4);
		panCampos.setHgap(20);
		panCampos.setVgap(20);

		
		panBotoes.getChildren().addAll(btnConcluir, btnAlterar, btnExcluir, btnVoltar);
		panBotoes.setHgap(70);
		panBotoes.setVgap(20);
		
		//Colocando ação no botão para ele ir pro Cadastro de Produto
				btnVoltar.setOnAction((a)-> {
					TelaInicial inicial = new TelaInicial();
					try {
						inicial.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		
		
		
		
		
		Scene scn = new Scene(panPrincipal, 600, 350);
		
		
		
		stage.setScene(scn);
		stage.setTitle("GM Stock - Cadastro Fornecedor");
		stage.setResizable(false);
		stage.show();
		
		
	}
	
	public static void main (String args[]){
		
		launch(args);
	}

}
