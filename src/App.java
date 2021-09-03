
import view.MainView;
import model.structure.Arbol;
import model.system.Persona;

public class App {

    public static void main(String[] args) {
        Arbol arbol = new Arbol(2);
        Arbol personas = new Arbol();
        Arbol transacciones = new Arbol();
        MainView mainView = new MainView(arbol);

        // Crear personas random
        Persona rochi = new Persona("Rochi000", "Rochi", "Coins", 000, 1000000000);
        
        personas.add(rochi);
        for (int i = 0; i < 100; i++) {
            personas.add(new Persona("Bot" + i , "Bot", "Bit bo", i, 0));
        }

        arbol.add(personas);
        arbol.add(transacciones);
    
        mainView.setVisible(true);
    }

}