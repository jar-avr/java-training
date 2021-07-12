package ua.training;

public final class Student {
    private final String name;
    private final int age;
    private final String group;
    private final Faculty faculty;

    public Student(String name, int age, String group, Faculty faculty) {
        this.name = name;
        this.age = age;
        this.group = group;
        Faculty tempFaculty = new Faculty();
        tempFaculty.setName(faculty.getName());
        tempFaculty.setNumberStudents(faculty.getNumberStudents());
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGroup() {
        return group;
    }
    public Faculty getFaculty() {
        Faculty tempFaculty = new Faculty();
        tempFaculty.setName(this.faculty.getName());
        tempFaculty.setNumberStudents(this.faculty.getNumberStudents());
        return tempFaculty;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            Student student = (Student) obj;
            return getAge() == student.getAge() && getName().equals(student.getName())
                    && getGroup().equals(student.getGroup()) && getFaculty().equals(student.getFaculty());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return ((29 * age + ((getName() == null) ? 0 : getName().hashCode())) * 29 +
                ((getGroup() == null) ? 0 : getGroup().hashCode())) * 29 +
                ((getFaculty() == null) ? 0 : getFaculty().hashCode());
    }
}
