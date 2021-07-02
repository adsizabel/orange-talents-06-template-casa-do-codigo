package br.com.zup.ot6.izabel.casadocodigo.excecoes;

public class ErroRespostaPadrao {
    private Long timestamp;
    private Integer status;
    private String erro;
    private String messagem;
    private String uri;

    public ErroRespostaPadrao() {
    }

    public ErroRespostaPadrao(Long timestamp, Integer status, String erro, String messagem, String uri) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.messagem = messagem;
        this.uri = uri;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
