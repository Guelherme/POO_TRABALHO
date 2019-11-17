package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EstoqueBoundary extends Application {
	
	private Button btnVerificar = new Button("Verificar Estoque");
	private Button btnAlterar = new Button("Alterar Estoque ");
	private Button btnVoltar = new Button(" Voltar ");
	

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
		
		panCampos.add(new Label("                     ESTOQUE"), 10, 5);
		panCampos.setHgap(20);
		panCampos.setVgap(20);
		
		panBotoes.getChildren().addAll(btnVerificar, btnAlterar, btnVoltar);
		panBotoes.setHgap(20);
		panBotoes.setVgap(70);
		
		panCampos.add(panBotoes, 9, 10, 5, 1);
		
		//Botao de voltar a tela inicial
		btnVoltar.setOnAction((a)-> {
					TelaInicial inicial = new TelaInicial();
					try {
						inicial.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				
		//Botao vai para a tela "Verifica Estoque"
				btnVerificar.setOnAction((a)-> {
					VerificaEstoque verifica = new VerificaEstoque();
					try {
						verifica.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				
		//Botao vai para a tela "Alterar Estoque"
				btnAlterar.setOnAction((a)-> {
					AlterarEstoque altera = new AlterarEstoque();
					try {
						altera.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		
		
		
		
		Scene scn = new Scene(panPrincipal, 600, 350);
		stage.setScene(scn);
		stage.setTitle("GM Stock - Estoque");
		stage.show();
		
		
	}
	public static void main(String[]args){
		launch(args);
		
		
	}
}
