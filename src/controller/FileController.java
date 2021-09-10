package controller;

import model.structure.Arbol;
import view.WelcomeView;

public class FileController {

    private final Arbol arbol;
    
    public FileController(Arbol arbol) {
        this.arbol = arbol;
    }

    public void load() {
        WelcomeView welcomeView = new WelcomeView();
        
        welcomeView.setMaxValue(6);
        welcomeView.setVisible(true);
        
        int i = 0; // Esto es solo temporal!!!!!
        while (i <= 6) {
            welcomeView.progress();
            i++;
        }
        
        welcomeView.setVisible(false);
    }

}