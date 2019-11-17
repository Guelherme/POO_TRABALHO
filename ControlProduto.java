package Control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class ControlProduto {

	private String Quantidade; 
	private String Unidade; 
	private String Nome;
	private String Tipo;
	private String Codigo;

	//ALT+SHIFT+S+R PARA CRIAR OS GET E OS SETS
	
	
	public String getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getUnidade() {
		return Unidade;
	}
	public void setUnidade(String unidade) {
		Unidade = unidade;
	}

	public String salvar(){		
		try {
			FileWriter fw = new FileWriter("Produtos.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Codigo" + this.Codigo);
			pw.println("Tipo" + this.Tipo);
			pw.println("Nome" + this.Nome);
			pw.println("Unidade" + this.Unidade);
			pw.println("Quantidade" + this.Quantidade);
			pw.flush();
			pw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
}

	
	
	
	
	

}
