package com.meuprojeto.logistica.sustentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private String status; // Ex: PENDENTE, PROCESSADO, ERRO

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}