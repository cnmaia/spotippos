package br.com.cmaia.domain.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256)
    private String name;

    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "upper_leftx")),
            @AttributeOverride(name = "y", column = @Column(name = "upper_lefty"))
    })
    private ProvinceBoundary upperLeftBoundary;

    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "bottom_rightx")),
            @AttributeOverride(name = "y", column = @Column(name = "bottom_righty"))
    })
    private ProvinceBoundary bottomRightBoundary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceBoundary getUpperLeftBoundary() {
        return upperLeftBoundary;
    }

    public void setUpperLeftBoundary(ProvinceBoundary upperLeftBoundary) {
        this.upperLeftBoundary = upperLeftBoundary;
    }

    public ProvinceBoundary getBottomRightBoundary() {
        return bottomRightBoundary;
    }

    public void setBottomRightBoundary(ProvinceBoundary bottomRightBoundary) {
        this.bottomRightBoundary = bottomRightBoundary;
    }

    public ProvinceBoundary getUpperRightBoundary() {
        if (this.upperLeftBoundary != null && this.bottomRightBoundary != null)
            return new ProvinceBoundary(this.upperLeftBoundary.getX(), this.bottomRightBoundary.getY());

        return null;
    }

    public ProvinceBoundary getBottomLeftBoundary() {
        if (this.bottomRightBoundary != null && this.upperLeftBoundary != null)
            return new ProvinceBoundary(this.bottomRightBoundary.getX(), this.upperLeftBoundary.getY());

        return null;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upperLeftBoundary=" + upperLeftBoundary +
                ", upperRightBoundary=" + getUpperRightBoundary() +
                ", bottomRightBoundary=" + bottomRightBoundary +
                ", bottomLeftBoundary=" + getBottomLeftBoundary() +
                '}';
    }
}