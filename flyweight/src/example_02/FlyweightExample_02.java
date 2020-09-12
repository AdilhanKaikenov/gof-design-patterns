package example_02;

import java.util.WeakHashMap;

/**
 * Wikipedia says
 *
 * In computer programming, flyweight is a software design pattern. A flyweight is an object that minimizes memory use by sharing as much
 * data as possible with other similar objects; it is a way to use objects in large numbers when a simple repeated representation would
 * use an unacceptable amount of memory.
 *
 * Use when the objects contain duplicate states which can be extracted and shared between multiple objects
 */
public class FlyweightExample_02 {
    public static void main(String[] args) {
        final StudentCache studentCache = new StudentCache();
        StudentUniversityInfo informatics1 = studentCache.getStudentUniversityInfo("informatics");
        StudentUniversityInfo informatics2 = studentCache.getStudentUniversityInfo("informatics");

        // We put student university info in the cache, so we do not duplicate objects
        System.out.println(informatics1 == informatics2);
    }
}

// Student information that will vary from one to the next
class StudentPersonalInfo {
    private String name;
    private int age;
    private String address;
    private int course;
    private double averageMark;
}

class Hostel {
}

// Student information that will be the same at the faculty level
class StudentUniversityInfo {
    private String faculty;
    private String universityCity;
    private Hostel hostel;

    public StudentUniversityInfo(final String faculty, final String universityCity, final Hostel hostel) {
        this.faculty = faculty;
        this.universityCity = universityCity;
        this.hostel = hostel;
    }
}

class StudentCache {
    public static final WeakHashMap<String, StudentUniversityInfo> STUDENT_UNIVERSITY_INFOS = new WeakHashMap<>();

    public StudentUniversityInfo getStudentUniversityInfo(String faculty) {
        StudentUniversityInfo studentUniversityInfo = STUDENT_UNIVERSITY_INFOS.get(faculty);

        if (studentUniversityInfo == null) {
            studentUniversityInfo = createStudentUniversityInfo(faculty);
            STUDENT_UNIVERSITY_INFOS.put(faculty, studentUniversityInfo);
        }
        return studentUniversityInfo;
    }

    private StudentUniversityInfo createStudentUniversityInfo(String faculty) {
        switch (faculty) {
            case "informatics":
                return new StudentUniversityInfo(faculty, "New York", new Hostel());
            case "management":
                return new StudentUniversityInfo(faculty, "Los Angeles", new Hostel());
            default:
                throw new IllegalArgumentException("no faculty");
        }
    }
}