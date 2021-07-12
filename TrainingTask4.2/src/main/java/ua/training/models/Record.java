package ua.training.models;

public class Record {
    private String name;
    private String surname;
    private String login;

    public Record() {
        this.name = "";
        this.surname = "";
        this.login = "";
    }
    public Record(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAndCheckLogin(String login) throws IllegalArgumentException {
        this.setLogin(login);
        for (Record writtenRecord : Notebook.getNotebook()) {
            if (writtenRecord.getLogin().equals(login)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
