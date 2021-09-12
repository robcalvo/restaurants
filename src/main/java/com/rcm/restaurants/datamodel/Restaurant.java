package com.rcm.restaurants.datamodel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Restaurant {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "restaurant_seq"
    )
    @SequenceGenerator(
        name = "restaurant_seq",
        allocationSize = 1
    )
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @OneToMany(mappedBy="restaurant")
    private List<Review> reviews;


    protected Restaurant() {
    }

    public Restaurant(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
