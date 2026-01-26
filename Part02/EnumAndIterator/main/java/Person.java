public class Person {
    private String name;
    private Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public Education getEducation() {
        return education;
    }

    public String toString() {
        return name + ", " + education;
    }

}
