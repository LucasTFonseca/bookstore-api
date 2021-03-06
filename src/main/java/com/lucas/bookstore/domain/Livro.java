package com.lucas.bookstore.domain;

import java.util.Objects;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String titulo;
  private String nome_autor;
  private String texto;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  public Livro() {
    super();
  }

  public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
    this.id = id;
    this.titulo = titulo;
    this.nome_autor = nome_autor;
    this.texto = texto;
    this.categoria = categoria;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTexto() {
    return this.texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Livro)) {
      return false;
    }
    Livro livro = (Livro) o;
    return Objects.equals(id, livro.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
