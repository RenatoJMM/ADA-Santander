package Brasileirao_Test.model;

import java.util.Objects;

public class DadosGolsFutebol {

    private Integer partidaId;
    private Integer rodada;
    private String clube;
    private String atleta;
    private Integer minuto;
    private String tipoDeGol;

    public DadosGolsFutebol(Integer partidaId, Integer rodada, String clube, String atleta, Integer minuto,
            String tipoDeGol) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipoDeGol = tipoDeGol;
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

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public String getTipoDeGol() {
        return tipoDeGol;
    }

    public void setTipoDeGol(String tipoDeGol) {
        this.tipoDeGol = tipoDeGol;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        DadosGolsFutebol that = (DadosGolsFutebol) object;
        return Objects.equals(partidaId, that.partidaId) && Objects.equals(rodada, that.rodada)
                && Objects.equals(clube, that.clube) && Objects.equals(atleta, that.atleta)
                && Objects.equals(minuto, that.minuto) && Objects.equals(tipoDeGol, that.tipoDeGol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partidaId, rodada, clube, atleta, minuto, tipoDeGol);
    }

    @Override
    public String toString() {
        return "DadosGolsFutebol{" + "partidaId=" + partidaId + ", rodada=" + rodada + ", clube='" + clube + '\''
                + ", atleta='" + atleta + '\'' + ", minuto=" + minuto + ", tipoDeGol='" + tipoDeGol + '\'' + '}';
    }
}
