package com.rcm.restaurants.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Review {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "review_seq"
    )
    @SequenceGenerator(
        name = "review_seq",
        allocationSize = 1
    )
    private Integer id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private Restaurant restaurant;

    private String reviewerName;

    private String comment;

    @NotNull
    @Min(1)
    @Max(5)
    private int stars;

    protected Review() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
