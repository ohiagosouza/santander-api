package com.hiagosouza.api_santander.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tab_card")
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String number;

  @Column(name = "available_limit", precision = 16, scale = 2)
  private BigDecimal limit;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public BigDecimal getLimit() {
    return limit;
  }

  public void setLimit(BigDecimal limit) {
    this.limit = limit;
  }

}
