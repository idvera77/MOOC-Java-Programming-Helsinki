public enum Education {
    PHD("Doctoral degree"),
    MA("Masters degree"),
    BA("Bachelors degree"),
    HS("High School diploma");

    private final String description;

    private Education(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
