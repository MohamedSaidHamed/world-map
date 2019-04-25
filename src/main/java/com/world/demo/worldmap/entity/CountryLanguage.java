/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mohamed
 */
@Entity
@Table(name = "country_language")
public class CountryLanguage implements Serializable {
    @EmbeddedId
    private CountryLanguagePK countryLanguagePK;
    
    @Column(name = "is_official")
    private boolean isOfficial;
    @Column(name = "percentage")
    private float percentage;
    @Column(name = "language")
    private String language;
    @JoinColumn(name = "country_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Country country;

    public CountryLanguagePK getCountryLanguagePK() {
        return countryLanguagePK;
    }

    public void setCountryLanguagePK(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public boolean isIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
