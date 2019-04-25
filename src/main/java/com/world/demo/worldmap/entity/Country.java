/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Mohamed
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    @JsonIgnore
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "continent")
    private String continent;
    @JsonIgnore
    @Column(name = "region")
    private String region;
    @Column(name = "surface_area")
    @JsonIgnore
    private float surfaceArea;
    @JsonIgnore
    @Column(name = "indep_year")
    private Short indepYear;
    @Column(name = "population")
    private int population;
    @Column(name = "life_expectancy")
    private Float lifeExpectancy;
    @JsonIgnore
    @Column(name = "gnp")
    private BigDecimal gnp;
    @JsonIgnore
    @Column(name = "gnp_old")
    private BigDecimal gnpOld;
    @JsonIgnore
    @Column(name = "local_name")
    private String localName;
    @JsonIgnore
    @Column(name = "government_form")
    private String governmentForm;
    @JsonIgnore
    @Column(name = "head_of_state")
    private String headOfState;
    @JsonIgnore
    @Column(name = "code2")
    private String code2;
    @JsonIgnore
    @JoinColumn(name = "capital", referencedColumnName = "id")
    @ManyToOne
    private City capital;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    private List<City> cityList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<CountryLanguage> countryLanguageList;

    @Transient
    private String country_language;

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public BigDecimal getGnp() {
        return gnp;
    }

    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    public BigDecimal getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(BigDecimal gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<CountryLanguage> getCountryLanguageList() {
        return countryLanguageList;
    }

    public void setCountryLanguageList(List<CountryLanguage> countryLanguageList) {
        this.countryLanguageList = countryLanguageList;
    }

    public String getCountry_language() {
        if (country_language == null) {
            this.setCountry_language(this.getCountryLanguageList()
                    .stream().filter(c -> c.isIsOfficial())
                    .findFirst().get().getLanguage());
        }
        return country_language;
    }

    public void setCountry_language(String country_language) {
        this.country_language = country_language;
    }

}
