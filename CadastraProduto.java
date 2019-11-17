package Boundary;


import Control.ControlProduto;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class CadastraProduto extends Application {
	
	
	private DatePicker dataRecebimento = new DatePicker();
	private DatePicker dataValidade = new DatePicker();
	private TextField txtCodigo = new TextField();
	private TextField txtTipo = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtUnidade = new TextField();
	private TextField txtQuantidade = new TextField();
	private Button btnConcluir = new Button("Concluir");
	private Button btnDescartar = new Button("Descartar");
	private Button btnVoltar = new Button("Voltar");

	private ComboBox<String> comboFornecedor = new ComboBox<String>();

	@Override
	public void start(Stage stage) throws Exception {
		
		BorderPane Principal = new BorderPane();
		GridPane Painel = new GridPane();
		FlowPane Botoes = new FlowPane();
		
		//colocando imagem de Fundo
		Image fundo = new Image(getClass().getResourceAsStream("/Imagem/Fundo.jpg"));
		ImageView imgView = new ImageView(fundo);
		Principal.getChildren().add(imgView);
		
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(10);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(10);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(10);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(10);
		
		Painel.getRowConstraints().addAll(row1, row2, row3, row4);
		Painel.setHgap(20);
		Painel.setVgap(20);
		
		Painel.getColumnConstraints().addAll(col0, col1);
		
		Principal.setCenter(Painel);
		Principal.setBottom(Botoes);
		
		ObservableList<String> opcoes = FXCollections.observableArrayList("Marcelo","Pedro","João","Rafael");
		
		
		
		Painel.add(new Label("Código Produto") , 0, 1);
		Painel.add(txtCodigo, 1, 1);
		
		Painel.add(new Label ("Tipo Produto"), 2, 1);
		Painel.add(txtTipo, 3, 1);
		
		Painel.add(new Label("Nome do Produto"), 0, 2);
		Painel.add(txtNome, 1, 2);
		
		Painel.add(new Label("Unidade"), 0, 3);
		Painel.add(txtUnidade, 1, 3);
		
		Painel.add(new Label("KG / Gramas"), 0, 4);
		Painel.add(txtQuantidade, 1, 4);
		
		Painel.add(new Label("Data Recebimento"), 2, 4);
		Painel.add(dataRecebimento, 3, 4);
		
		Painel.add(new Label("Fornecedores"), 0, 5);
		Painel.add(comboFornecedor, 1, 5);
		
		Painel.add(new Label("Data Validade"), 2, 6 );
		Painel.add(dataValidade, 3, 6);
		
		
		Botoes.getChildren().addAll(btnConcluir, btnDescartar, btnVoltar);
		Botoes.setHgap(20);
		Botoes.setVgap(70);
		
		//Botao de voltar a tela inicial
		btnVoltar.setOnAction((a)-> {
			TelaInicial inicial = new TelaInicial();
			try {
				inicial.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		comboFornecedor.setItems(opcoes);
		
		
		
		
		
		btnConcluir.setOnAction((a)-> {
			ControlProduto produto = new ControlProduto();
			
			produto.setCodigo(txtCodigo.getText());
			produto.setTipo(txtTipo.getText());
			produto.setNome(txtNome.getText());
			produto.setUnidade(txtUnidade.getText());
			produto.setQuantidade(txtQuantidade.getText());
			
			txtCodigo.setText(" ");
			txtTipo.setText(" ");
			txtNome.setText(" ");
			txtUnidade.setText(" ");
			txtQuantidade.setText(" ");
		});	
		
		Scene scn = new Scene(Principal, 600, 350);
		
		stage.setScene(scn);
		stage.setTitle("GM Stock - Cadastro Produto");
		stage.setResizable(false);
		stage.show();
		
		
	}
	
	public static void main (String args[]){
		launch(args);
		
		
	}
	
	

}
