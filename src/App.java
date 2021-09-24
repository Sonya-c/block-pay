
import model.structure.Arbol;
import controller.FileController;
import controller.JoinController;

public class App {

    public static void main(String[] args) {
        Arbol arbol = new Arbol(2);
        
        System.out.println("App llamar al file controller");
        FileController fileCtrl = new FileController(arbol, "C:\\Block-Pay\\", "registrosUsuarios.txt", "registrosTransacciones.txt");
        fileCtrl.init();
        
        System.out.println("App llamar al Join controller");
        JoinController joinCtrl = new JoinController(arbol);
        joinCtrl.join();
        
    }
}