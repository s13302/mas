package pl.s13302.mas.model;

import java.math.BigDecimal;
import java.util.*;

public class Movie extends ObjectPlus {

    private Long id;
    private String title;
    private Date releaseDate;
    private Set<String> category = new HashSet<>();
    private Rating rating;
    private BigDecimal budget;
    private BigDecimal income;
    private static Set<String> KNOWN_CATEGORIES;

    static {
        KNOWN_CATEGORIES = new HashSet<>();
        KNOWN_CATEGORIES.add("Sci-Fi");
        KNOWN_CATEGORIES.add("Thiller");
    }

    public Movie(Long id, String title, Date releaseDate, Rating rating, String... categories) {
        super();
        setId(id);
        setTitle(title);
        setReleaseDate(releaseDate);
        setRating(rating);
        addCategories(categories);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) {
            throw new NullPointerException("`id` field cannot be null");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.length() == 0) {
            throw new NullPointerException("`title` field cannot be null or empty");
        }
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        if (releaseDate == null) {
            throw new NullPointerException("`releaseDate` field cannot be null");
        }
        this.releaseDate = releaseDate;
    }

    public Set<String> getCategory() {
        return category;
    }

    public void addCategories(String... categories) {
        if (categories == null || categories.length < 1) {
            throw new NullPointerException("`category` field cannot be null or should contain at least one value");
        }
        for (String category : categories) {
            addCategory(category);
        }
    }

    public void addCategory(String category) {
        if (! KNOWN_CATEGORIES.contains(category)) {
            throw new IllegalArgumentException("Unknown category: `" + category + "`");
        }
        getCategory().add(category);
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        if (rating == null) {
            throw new NullPointerException("`rating` field cannot be null");
        }
        this.rating = rating;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getProfit() {
        if (getBudget() != null && getIncome() != null) {
            return getIncome().subtract(getBudget());
        }
        return BigDecimal.ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(category, movie.category) &&
                rating == movie.rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", releaseDate=" + getReleaseDate() +
                ", category=" + getCategory() +
                ", rating=" + getRating() +
                ", budget=" + getBudget() +
                ", income=" + getIncome() +
                ", profit=" + getProfit() +
                '}';
    }
}
