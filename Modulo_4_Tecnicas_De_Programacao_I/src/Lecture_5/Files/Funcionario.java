package Lecture_5.Files;

import java.time.LocalDate;

public class Funcionario {

    private Integer id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private String cidade;
    private String cargo;
    private LocalDate dataAdmissao;
    private Double salario;

    public Funcionario(Integer id, String nome, String sexo, LocalDate dataNascimento, String cidade, String cargo,
            LocalDate dataAdmissao, Double salario) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario [cargo=" + cargo + ", cidade=" + cidade + ", dataAdmissao=" + dataAdmissao
                + ", dataNascimento=" + dataNascimento + ", id=" + id + ", nome=" + nome + ", salario=" + salario
                + ", sexo=" + sexo + "]";
    }

}
