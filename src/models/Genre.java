package models;

public class Genre {
    private String name;
    private String description;
    private int popularity;

    public Genre(String name, String description, int popularity) {
        this.name = name;
        this.description = description;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }
}


