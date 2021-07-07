package ua.training;

import ua.training.controllers.Controller;
import ua.training.models.Notebook;
import ua.training.views.View;

public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}
