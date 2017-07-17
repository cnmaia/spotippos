package br.com.cmaia.domain.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private int x;
    private int y;
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
            message = "A property in Spotippos have a maximum of {value} baths."
    )
    @Min(
            value = 1,
            message = "A property in Spotippos have at least {value} baths."
    )
    private int baths;
    @Max(
            value = 240,
            message = "A property in Spotippos have a maximum of {value} square meters."
    )
    @Min(
            value = 20,
            message = "A property in Spotippos have at least {value} square meters."
    )
    private double squareMeters;

    @ManyToMany
    @JoinTable(name = "property_province",
            joinColumns = { @JoinColumn(name = "property_id") },
            inverseJoinColumns = { @JoinColumn(name = "province_id" )})
    @NotNull(message = "A property in Spotippos have at least {value} provinces.")
    @Size(
            min = 1,
            message = "A property in Spotippos have at least {value} provinces."
    )
    private Set<Province> provinces = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", beds=" + beds +
                ", baths=" + baths +
                ", provinces=" + provinces +
                ", squareMeters=" + squareMeters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return id != null ? id.equals(property.id) : property.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
