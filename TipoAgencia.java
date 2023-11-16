
public enum TipoAgencia {
	
	AGENCIA_PRINCIPAL(1, " - Agencia Principal"), AGENCIA_VIRTUAL(2, " - Agencia Virtual");
	
	private int id;
	private String descricao;
	
	private TipoAgencia(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public static TipoAgencia valueOf(int opcao) {
		for (TipoAgencia tipo : TipoAgencia.values()) {
			if (tipo.getId() == opcao) {
				return tipo;
			}
		}
		return null;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
