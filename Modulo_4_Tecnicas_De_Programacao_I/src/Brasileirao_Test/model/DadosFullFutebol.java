package Brasileirao_Test.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class DadosFullFutebol {

    private Integer id;
    private Integer rodada;
    private LocalDate data;
    private LocalTime hora;
    private String mandante;
    private String visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private Integer mandantePlacar;
    private Integer visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;

    public DadosFullFutebol(Integer id, Integer rodada, LocalDate data, LocalTime hora, String mandante,
            String visitante, String formacaoMandante, String formacaoVisitante, String tecnicoMandante,
            String tecnicoVisitante, String vencedor, String arena, Integer mandantePlacar, Integer visitantePlacar,
            String mandanteEstado, String visitanteEstado) {
        this.id = id;
        this.rodada = rodada;
        this.data = data;
        this.hora = hora;
        this.mandante = mandante;
        this.visitante = visitante;
        this.formacaoMandante = formacaoMandante;
        this.formacaoVisitante = formacaoVisitante;
        this.tecnicoMandante = tecnicoMandante;
        this.tecnicoVisitante = tecnicoVisitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.mandanteEstado = mandanteEstado;
        this.visitanteEstado = visitanteEstado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getFormacaoMandante() {
        return formacaoMandante;
    }

    public void setFormacaoMandante(String formacaoMandante) {
        this.formacaoMandante = formacaoMandante;
    }

    public String getFormacaoVisitante() {
        return formacaoVisitante;
    }

    public void setFormacaoVisitante(String formacaoVisitante) {
        this.formacaoVisitante = formacaoVisitante;
    }

    public String getTecnicoMandante() {
        return tecnicoMandante;
    }

    public void setTecnicoMandante(String tecnicoMandante) {
        this.tecnicoMandante = tecnicoMandante;
    }

    public String getTecnicoVisitante() {
        return tecnicoVisitante;
    }

    public void setTecnicoVisitante(String tecnicoVisitante) {
        this.tecnicoVisitante = tecnicoVisitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public Integer getMandantePlacar() {
        return mandantePlacar;
    }

    public void setMandantePlacar(Integer mandantePlacar) {
        this.mandantePlacar = mandantePlacar;
    }

    public Integer getVisitantePlacar() {
        return visitantePlacar;
    }

    public void setVisitantePlacar(Integer visitantePlacar) {
        this.visitantePlacar = visitantePlacar;
    }

    public String getMandanteEstado() {
        return mandanteEstado;
    }

    public void setMandanteEstado(String mandanteEstado) {
        this.mandanteEstado = mandanteEstado;
    }

    public String getVisitanteEstado() {
        return visitanteEstado;
    }

    public void setVisitanteEstado(String visitanteEstado) {
        this.visitanteEstado = visitanteEstado;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        DadosFullFutebol that = (DadosFullFutebol) object;
        return Objects.equals(id, that.id) && Objects.equals(rodada, that.rodada) && Objects.equals(data, that.data)
                && Objects.equals(hora, that.hora) && Objects.equals(mandante, that.mandante)
                && Objects.equals(visitante, that.visitante) && Objects.equals(formacaoMandante, that.formacaoMandante)
                && Objects.equals(formacaoVisitante, that.formacaoVisitante)
                && Objects.equals(tecnicoMandante, that.tecnicoMandante)
                && Objects.equals(tecnicoVisitante, that.tecnicoVisitante) && Objects.equals(vencedor, that.vencedor)
                && Objects.equals(arena, that.arena) && Objects.equals(mandantePlacar, that.mandantePlacar)
                && Objects.equals(visitantePlacar, that.visitantePlacar)
                && Objects.equals(mandanteEstado, that.mandanteEstado)
                && Objects.equals(visitanteEstado, that.visitanteEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rodada, data, hora, mandante, visitante, formacaoMandante, formacaoVisitante,
                tecnicoMandante, tecnicoVisitante, vencedor, arena, mandantePlacar, visitantePlacar, mandanteEstado,
                visitanteEstado);
    }

    @Override
    public String toString() {
        return "DadosFullFutebol{" + "id=" + id + ", rodada=" + rodada + ", data=" + data + ", hora=" + hora
                + ", mandante='" + mandante + '\'' + ", visitante='" + visitante + '\'' + ", formacaoMandante='"
                + formacaoMandante + '\'' + ", formacaoVisitante='" + formacaoVisitante + '\'' + ", tecnicoMandante='"
                + tecnicoMandante + '\'' + ", tecnicoVisitante='" + tecnicoVisitante + '\'' + ", vencedor='" + vencedor
                + '\'' + ", arena='" + arena + '\'' + ", mandantePlacar=" + mandantePlacar + ", visitantePlacar="
                + visitantePlacar + ", mandanteEstado='" + mandanteEstado + '\'' + ", visitanteEstado='"
                + visitanteEstado + '\'' + '}';
    }
}
