package Boundary;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaInicial extends Application{
	
	
	private Button btnAcao = new Button ("  Cadastra Produto     ");
	private Button btnAcao1 = new Button("Verifica/Altera Estoque");
	private Button btnAcao2 = new Button("  Cadastra Funcionario ");
	private Button btnAcao3 = new Button("  Cadastrar Fornecedor ");
	private Button btnAcao4 = new Button("   Gerar Relatorio     ");
	
	private Button btnTrocar = new Button("Trocar Usuario");
	private Button btnFechar = new Button("    Fechar    ");

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panPrincipal = new BorderPane();
		GridPane panCampos = new GridPane();
		FlowPane panBotoes = new FlowPane();
		
		
		HBox teste = new HBox();
		teste.setSpacing(10);
		teste.setAlignment(Pos.CENTER);
		
		teste.setTranslateX(10);
		teste.setTranslateY(40);
		
		
		//colocando imagem de Fundo
		Image fundo = new Image(getClass().getResourceAsStream("/Imagem/Fundo.jpg"));
		ImageView imgView = new ImageView(fundo);
		panPrincipal.getChildren().add(imgView);

		
		panPrincipal.setTop(panCampos);
		panPrincipal.setCenter(teste);
		
		panCampos.add(btnAcao, 4, 1);
		panCampos.add(btnAcao1, 4,2);
		panCampos.add(btnAcao2, 4, 3);
		panCampos.add(btnAcao3, 4, 4);
		panCampos.add(btnAcao4, 4, 5);
		
		panCampos.setHgap(60);
		panCampos.setVgap(20);
		
		
		
		//Colocando ação no botão para ele ir pro Cadastro de Produto
		btnAcao.setOnAction((a)-> {
			CadastraProduto produto = new CadastraProduto();
			try {
				produto.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		//Colocando ação no botão para ele ir para as Telas de Estoque
		btnAcao1.setOnAction((a)-> {
			EstoqueBoundary estoque = new EstoqueBoundary();
			try {
				estoque.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		//Colocando ação no botão para ele Cadastrar Funcionario
		btnAcao2.setOnAction((a)-> {
			FuncionarioBoundary funcionario = new FuncionarioBoundary();
			try {
				funcionario.start(stage);
			} catch (Exception e) {
				System.out.println("Falha no Login !!");
				e.printStackTrace();
			}
		});
		
		//Colocando ação no botão para ele Cadastrar o Fornecedor
		btnAcao3.setOnAction((a)-> {
			FornecedorBoundary fornecedor = new FornecedorBoundary();
			try {
				fornecedor.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		//Colocando ação no botão para ele ir para a ABA de Relatorio
		btnAcao4.setOnAction((a)-> {
			RelatorioEstoque relatorio = new RelatorioEstoque();
			try {
				relatorio.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
			
			
		teste.getChildren().addAll(btnTrocar, btnFechar);
		panBotoes.setHgap(70);
		panBotoes.setVgap(20);
		//panCampos.add(panBotoes, 3, 10, 5, 5);
		
		
		btnTrocar.setOnAction((a)-> {
			LoginBoundary login = new LoginBoundary();
			try {
				login.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		btnFechar.setOnAction((a)-> {
			try {
				stage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		
		Scene scn = new Scene(panPrincipal, 600, 350);
		
		stage.setScene(scn);
		stage.setTitle("GM Stock - Tela Inicial");
		stage.setResizable(false);
		stage.show();
		
	}
	
	public static void main(String []args){
		launch(args);

		
	}
}
