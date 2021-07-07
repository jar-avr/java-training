package ua.training.models;

import java.util.LinkedHashSet;

/**
 * Model of the program.
 *
 * @version 2.0 7 June 2021
 * @author Yaroslav Avramenko
 */
public class Notebook {
    private LinkedHashSet<Record> notebook;

    public Notebook() {
        notebook = new LinkedHashSet<>();
    }

    public Notebook(LinkedHashSet<Record> notebook) {
        this.notebook = notebook;
    }

    public LinkedHashSet<Record> getNotebook() {
        return notebook;
    }

    public void setNotebook(LinkedHashSet<Record> notebook) {
        this.notebook = notebook;
    }

    public boolean addRecord(Record record) {
        return notebook.add(record);
    }
}
