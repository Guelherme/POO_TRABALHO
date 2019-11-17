package Boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginBoundary extends Application implements EventHandler<ActionEvent> {
	
	private Label login = new Label("Login");
	private Label senha = new Label("Senha");
	private TextField txtLogin = new TextField();
	private Button btnEntrar = new Button("Entrar");
	private PasswordField passaword = new PasswordField();
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panPrincipal = new BorderPane();
		GridPane panCampos = new GridPane();
		FlowPane panBotoes = new FlowPane();
		
		
		//colocando imagem como icone; 
		Image image = new Image (getClass().getResourceAsStream("/Imagem/Icon.png"));
		stage.getIcons().add(image);
		
		//colocando imagem de Fundo
		Image fundo = new Image(getClass().getResourceAsStream("/Imagem/Fundo.jpg"));
		ImageView imgView = new ImageView(fundo);
		panPrincipal.getChildren().add(imgView);
					
		//setando as linhas e colunas. 
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(75);
		
		panCampos.getColumnConstraints().addAll(col0, col1);
		panCampos.setHgap(5);
		panCampos.setVgap(5);
		
		
		
		
		//setando os paineis no Border Pane como Meio e como Inferior
		panPrincipal.setCenter(panCampos);
		panPrincipal.setBottom(panBotoes);
		
		
		//Colocando campos no GridPane
		panCampos.add(login, 0, 1);
		panCampos.add(txtLogin, 1, 1);
		login.setStyle("-fx-font-weight: bold");
		
		panCampos.add(senha, 0, 3);
		panCampos.add(passaword, 1, 3);	
		senha.setStyle("-fx-font-weight: bold");
		
		

		panBotoes.getChildren().addAll(btnEntrar);
		panBotoes.setVgap(10);
		panBotoes.setHgap(10);
		panCampos.add(panBotoes, 1, 4, 2, 1);
		
		
		//Colocando ação no botão para ele conseguir logar
		btnEntrar.setOnAction((a)-> {
			TelaInicial produto = new TelaInicial();
			try {
				produto.start(stage);
			} catch (Exception e) {
				System.out.println("Falha no Login !!");
				e.printStackTrace();
			}
		});
		
		
		
		// Chamada da tela
		Scene scn = new Scene(panPrincipal, 600, 350);
		
		stage.setScene(scn);
		stage.setTitle("GM Stock - Login");
		stage.setResizable(false);
		stage.show();
				
	}
	
	
	public static void main (String args[]){
		launch(args);
		
	}


	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
