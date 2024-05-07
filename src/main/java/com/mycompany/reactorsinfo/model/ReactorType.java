
package com.mycompany.reactorsinfo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "root")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReactorType {
    private String name;
    private final String reactorsClass;
    private final Double burnup;
    private final Double kpd;
    private final Double enrichment;
    private final Double termalCapacity;
    private final Double electricalCapacity;
    private final Double lifeTime;
    private final Double firstLoad;
    private String source;
    
    @JsonCreator
    public ReactorType(@JsonProperty("class")
                   @JacksonXmlProperty(localName = "class")
                   String reactorsClass,
                   @JsonProperty("burnup")
                   @JacksonXmlProperty(localName = "burnup")
                   Double burnup,
                   @JacksonXmlProperty(localName = "kpd")
                   @JsonProperty("kpd")
                   Double kpd,
                   @JacksonXmlProperty(localName = "enrichment")
                   @JsonProperty("enrichment")
                   Double enrichment,
                   @JacksonXmlProperty(localName = "termal_capacity")
                   @JsonProperty("termal_capacity")
                   Double termalCapacity,
                   @JacksonXmlProperty(localName = "electrical_capacity")
                   @JsonProperty("electrical_capacity")
                   Double electricalCapacity,
                   @JacksonXmlProperty(localName = "life_time")
                   @JsonProperty("life_time")
                   Double lifeTime,
                   @JacksonXmlProperty(localName = "first_load")
                   @JsonProperty("first_load")
                   Double firstLoad
                   ){
        
        this.reactorsClass = reactorsClass;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.termalCapacity = termalCapacity;
        this.electricalCapacity = electricalCapacity;
        this.lifeTime = lifeTime;
        this.firstLoad = firstLoad;
    }
    
    public String getName() {
        return name;
    }
    
    public String getReactorClass(){
        return reactorsClass;
    }

    public Double getBurnup(){
        return burnup;
    }
    
    public Double getKPD(){
        return kpd;
    }
     
    public Double getEnrichment(){
        return enrichment;
    }
    
    public Double getTermalCapacity(){
        return termalCapacity;
    }
    
    public Double getElectricalCapacity(){
        return electricalCapacity;
    }
    
    public Double getLifeTime(){
        return lifeTime;
    }
    
    public Double getFirstLoad(){
        return firstLoad;
    }
    
    public String getSource(){
        return source;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSource(String source){
        this.source = source;
    }
    
    public String[] getAtrributes() {
        return new String[] { name, 
                             "Класс: " + reactorsClass,
                             "Выгорание: " + burnup,
                             "КПД: " + kpd,
                             "Обогащение: " + enrichment,
                             "Термальная ёмкость: " + termalCapacity,
                             "Электрическая ёмкость: " + electricalCapacity,
                             "Время жизни: " + lifeTime,
                             "Первая загрузка: " + firstLoad,
                             "Источник данных: " + source};
        }
    }
    

        
    

    

