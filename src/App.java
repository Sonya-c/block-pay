
import model.structure.Arbol;
import controller.FileController;
import controller.JoinController;

public class App {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        FileController fileCtrl = new FileController(arbol);
        JoinController joinCtrl = new JoinController(arbol);
        
        fileCtrl.load();
        joinCtrl.join();   
    }
}