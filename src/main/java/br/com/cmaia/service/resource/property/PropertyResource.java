package br.com.cmaia.service.resource.property;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PropertyResource {
    private Long id;
    @JsonProperty("lat")
    private int x;
    @JsonProperty("long")
    private int y;
    private String title;
    private BigDecimal price; // This should use the money pattern
    private String description;
    @Max(
            value = 5,
            message = "A property in Spotippos have a maximum of {value} beds."
    )
    @Min(
            value = 1,
            message = "A property in Spotippos have at least {value} beds."
    )
    private int beds;
    @Max(
            value = 4,
            message = "A property in Spotippos have a maximum of 4 baths."
    )
    @Min(
            value = 1,
            message = "A property in Spotippos have at least 4 baths."
    )
    private int baths;
    @Max(
            value = 240,
            message = "A property in Spotippos have a maximum of 240 square meters."
    )
    @Min(
            value = 20,
            message = "A property in Spotippos have at least 240 square meters."
    )
    private double squareMeters;
    private Set<String> provinces = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Set<String> getProvinces() {
        return provinces;
    }

    public void setProvinces(Set<String> provinces) {
        this.provinces = provinces;
    }
}
