package Brasileirao_Test.model;

import java.util.Objects;

public class DadosEstatisticasFutebol {

    private Integer partidaId;
    private Integer rodada;
    private String clube;
    private Integer chutes;
    private Integer chutesNoAlvo;
    private String posseDeBola;
    private Integer passes;
    private String precisaoPasses;
    private Integer faltas;
    private Integer cartaoAmarelo;
    private Integer cartaoVermelho;
    private Integer impedimentos;
    private Integer escanteios;

    public DadosEstatisticasFutebol(Integer partidaId, Integer rodada, String clube, Integer chutes,
            Integer chutesNoAlvo, String posseDeBola, Integer passes, String precisaoPasses, Integer faltas,
            Integer cartaoAmarelo, Integer cartaoVermelho, Integer impedimentos, Integer escanteios) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.chutes = chutes;
        this.chutesNoAlvo = chutesNoAlvo;
        this.posseDeBola = posseDeBola;
        this.passes = passes;
        this.precisaoPasses = precisaoPasses;
        this.faltas = faltas;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
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

    public Integer getChutes() {
        return chutes;
    }

    public void setChutes(Integer chutes) {
        this.chutes = chutes;
    }

    public Integer getChutesNoAlvo() {
        return chutesNoAlvo;
    }

    public void setChutesNoAlvo(Integer chutesNoAlvo) {
        this.chutesNoAlvo = chutesNoAlvo;
    }

    public String getPosseDeBola() {
        return posseDeBola;
    }

    public void setPosseDeBola(String posseDeBola) {
        this.posseDeBola = posseDeBola;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public String getPrecisaoPasses() {
        return precisaoPasses;
    }

    public void setPrecisaoPasses(String precisaoPasses) {
        this.precisaoPasses = precisaoPasses;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public Integer getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(Integer cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public Integer getCartaoVermelho() {
        return cartaoVermelho;
    }

    public void setCartaoVermelho(Integer cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }

    public Integer getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(Integer impedimentos) {
        this.impedimentos = impedimentos;
    }

    public Integer getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(Integer escanteios) {
        this.escanteios = escanteios;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        DadosEstatisticasFutebol that = (DadosEstatisticasFutebol) object;
        return Objects.equals(partidaId, that.partidaId) && Objects.equals(rodada, that.rodada)
                && Objects.equals(clube, that.clube) && Objects.equals(chutes, that.chutes)
                && Objects.equals(chutesNoAlvo, that.chutesNoAlvo) && Objects.equals(posseDeBola, that.posseDeBola)
                && Objects.equals(passes, that.passes) && Objects.equals(precisaoPasses, that.precisaoPasses)
                && Objects.equals(faltas, that.faltas) && Objects.equals(cartaoAmarelo, that.cartaoAmarelo)
                && Objects.equals(cartaoVermelho, that.cartaoVermelho)
                && Objects.equals(impedimentos, that.impedimentos) && Objects.equals(escanteios, that.escanteios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partidaId, rodada, clube, chutes, chutesNoAlvo, posseDeBola, passes, precisaoPasses, faltas,
                cartaoAmarelo, cartaoVermelho, impedimentos, escanteios);
    }

    @Override
    public String toString() {
        return "DadosEstatisticasFutebol{" + "partidaId=" + partidaId + ", rodada=" + rodada + ", clube='" + clube
                + '\'' + ", chutes=" + chutes + ", chutesNoAlvo=" + chutesNoAlvo + ", posseDeBola='" + posseDeBola
                + '\'' + ", passes=" + passes + ", precisaoPasses='" + precisaoPasses + '\'' + ", faltas=" + faltas
                + ", cartaoAmarelo=" + cartaoAmarelo + ", cartaoVermelho=" + cartaoVermelho + ", impedimentos="
                + impedimentos + ", escanteios=" + escanteios + '}';
    }
}
