package br.com.cmaia.service.resource.property;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PropertyResource {
    private Long id;
    @JsonProperty("long")
    private int x;
    @JsonProperty("lat")
    private int y;
    private String title;
    private BigDecimal price; // This should use the money pattern
    private String description;
    @Max(5)
    @Min(1)
    private int beds;
    @Max(4)
    @Min(1)
    private int baths;
    @Max(240)
    @Min(20)
    private double squareMeters;

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
}
