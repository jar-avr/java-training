package ua.training;

public class Faculty {
    private String name;
    private int numberStudents;

    public void setName(String name) {
        this.name = name;
    }
    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public String getName() {
        return name;
    }
    public int getNumberStudents() {
        return numberStudents;
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
            Faculty faculty = (Faculty) obj;
            return getName().equals(faculty.getName()) && getNumberStudents() == faculty.getNumberStudents();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 43 * numberStudents + ((getName() == null) ? 0 : getName().hashCode());
    }
}
