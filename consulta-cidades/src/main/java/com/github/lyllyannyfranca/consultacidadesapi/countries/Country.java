package com.github.lyllyannyfranca.consultacidadesapi.countries;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@NoArgsConstructor
@Getter
public class Country {

    @Id
    private Long Id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String name_pt;

    @Column(name = "sigla")
    private String code;

    private Integer bacen;

}
