public class Agencia {
	
	private String numero;
	private String estado;
	private String cidade;
	
	public Agencia(String numero, String estado, String cidade) {
		super();
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
	}

	public Agencia() {
        
    }

	@Override
	public String toString() {
		return "número: " + numero + ", estado: " + estado + ", cidade: " + cidade;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}