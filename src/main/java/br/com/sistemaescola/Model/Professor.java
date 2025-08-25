package br.com.sistemaescola.Model;

import javax.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String disciplinaPrincipal;
    @Embedded
    private Endereco endereco;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDisciplinaPrincipal() { return disciplinaPrincipal; }
    public void setDisciplinaPrincipal(String disciplinaPrincipal) { this.disciplinaPrincipal = disciplinaPrincipal; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}
