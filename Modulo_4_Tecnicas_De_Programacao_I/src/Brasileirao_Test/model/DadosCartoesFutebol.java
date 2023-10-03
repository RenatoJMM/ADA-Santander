package Brasileirao_Test.model;

import java.util.Objects;

public class DadosCartoesFutebol {

    private Integer partidaId;
    private Integer rodada;
    private String clube;
    private String cartao;
    private String atleta;
    private Integer numCamisa;
    private String posicao;
    private Integer minuto;

    public DadosCartoesFutebol(Integer partidaId, Integer rodada, String clube, String cartao, String atleta,
            Integer numCamisa, String posicao, Integer minuto) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.numCamisa = numCamisa;
        this.posicao = posicao;
        this.minuto = minuto;
    }

    public Integer getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Integer partidaId) {
        this.partidaId = partidaId;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public Integer getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(Integer numCamisa) {
        this.numCamisa = numCamisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        DadosCartoesFutebol that = (DadosCartoesFutebol) object;
        return Objects.equals(partidaId, that.partidaId) && Objects.equals(rodada, that.rodada)
                && Objects.equals(clube, that.clube) && Objects.equals(cartao, that.cartao)
                && Objects.equals(atleta, that.atleta) && Objects.equals(numCamisa, that.numCamisa)
                && Objects.equals(posicao, that.posicao) && Objects.equals(minuto, that.minuto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partidaId, rodada, clube, cartao, atleta, numCamisa, posicao, minuto);
    }

    @Override
    public String toString() {
        return "DadosCartoesFutebol{" + "partidaId=" + partidaId + ", rodada=" + rodada + ", clube='" + clube + '\''
                + ", cartao='" + cartao + '\'' + ", atleta='" + atleta + '\'' + ", numCamisa=" + numCamisa
                + ", posicao='" + posicao + '\'' + ", minuto=" + minuto + '}';
    }
}
