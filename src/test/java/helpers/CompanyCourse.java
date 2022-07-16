package helpers;


import java.util.Date;

public class CompanyCourse {
    private String name;
    private Date dates;

    public CompanyCourse(String name, Date date) {
        this.name = name;
        this.dates = date;

    }

//    @Override
//    public String toString() {
//        return "CourseBlockEntity{" +
//                "name='" + name + '\'' +
//                ", startDate=" + dates +
//                '}';
//    }

    public String getName() {
        return name;
    }


    public Date getDates(){return dates;}
}
