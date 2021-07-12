package ua.training;

public class Driver {
    public static void main(String[] args) {
        Faculty faculty = new Faculty();
        faculty.setName("tef");
        faculty.setNumberStudents(800);
        Student student1 = new Student("John", 19, "TI-92", faculty);
        Student student2 = new Student("John", 19, "TI-92", faculty);
        Student student3 = new Student("Petya", 19, "TI-92", faculty);
        System.out.println("student1 equals student2? " + student1.equals(student2));
        System.out.println("student1 equals student3? " + student1.equals(student3));
        System.out.println("hashCode of student1: " + student1.hashCode());
        System.out.println("hashCode of student2: " + student2.hashCode());
        System.out.println("hashCode of student3: " + student3.hashCode());
    }
}
