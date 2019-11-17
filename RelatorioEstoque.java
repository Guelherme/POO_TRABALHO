package Boundary;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class RelatorioEstoque extends Application{

	private DatePicker dataInicial = new DatePicker();
	private DatePicker dataFinal = new DatePicker();
	private Button btnGerar = new Button("Gerar Relatorio");
	private Button btnImprimir = new Button ("Imprimir Relatorio");
	private Button btnVoltar = new Button ("Voltar");
	private ComboBox<String> comboRelatorio = new ComboBox<String>();
	
	

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
		
		
		ObservableList<String> opcoes = FXCollections.observableArrayList("Relatorio de Consumo","Relatorio de Produção","Relatorio de Lucro","Relatorio de Produtos","Relatorio Diario","Relatorio de Vendas");
		
		
		Scene scn = new Scene(panPrincipal, 600, 350);
		
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(20);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(20);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(20);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(10);
		
		panCampos.getRowConstraints().addAll(row1, row2, row3, row4);
		
		panCampos.getColumnConstraints().addAll(col0, col1);
		
	
		panCampos.add(new Label("Tipo de Relatorio"), 0, 0);
		panCampos.add(comboRelatorio, 1, 0);
		panCampos.add(new Label("Periodo"), 0, 1);
		panCampos.add(new Label ("Inicial"), 0, 2);
		panCampos.add(dataInicial, 1, 2);
		panCampos.add(new Label("Final"), 0, 3);
		panCampos.add(dataFinal, 1, 3);
		panCampos.setHgap(10);
		panCampos.setVgap(10);
	
		comboRelatorio.setItems(opcoes);
			
	
		
		panBotoes.getChildren().addAll(btnGerar, btnImprimir,btnVoltar);
		panBotoes.setVgap(30);
		panBotoes.setHgap(70);
		
		//Botao de voltar a tela inicial
				btnVoltar.setOnAction((a)-> {
					TelaInicial inicial = new TelaInicial();
					try {
						inicial.start(stage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		
		
		
		
		stage.setScene(scn);
		stage.setTitle("GM Stock - Gerar Relatorio");
		stage.show();
		
	}
	
	public static void main (String args[]){
		launch(args);
		
	}

}
