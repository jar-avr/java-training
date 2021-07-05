package ua.training;

import java.util.LinkedHashSet;

/**
 * Model of the program.
 *
 * @version 1.0 2 June 2021
 * @author Yaroslav Avramenko
 */
public class Notebook {
    private LinkedHashSet<Record> notebook;

    Notebook() {
        notebook = new LinkedHashSet<>();
    }

    Notebook(LinkedHashSet<Record> notebook) {
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
