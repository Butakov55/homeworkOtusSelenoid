package Components;

import java.time.LocalDate;

public class CourseEnter {
    private String name;
    private LocalDate startDate;

    public CourseEnter(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "CourseBlockEntity{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
