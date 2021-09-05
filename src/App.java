
import view.MainView;
import model.structure.Arbol;
import model.system.Persona;

public class App {

    public static void main(String[] args) {
        Arbol arbol = new Arbol(2);
  
        MainView mainView = new MainView(arbol);

        // Crear personas random
        Persona rochi = new Persona("Rochi000", "Rochi", "Coins", 000, 1000000000);
        
    
        mainView.setVisible(true);
    }

}