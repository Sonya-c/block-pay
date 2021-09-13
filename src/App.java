
import model.structure.Arbol;
import controller.FileController;
import controller.JoinController;
import model.structure.nodo.NodoArbol;
import model.system.Persona;
import model.system.Transaccion;

public class App {

    public static void main(String[] args) {
        Arbol arbol = new Arbol(2);
        NodoArbol root = arbol.getRoot();
        root = arbol.insert(root, 0);
        root = arbol.insert(root, new Persona("kelly", "kelly", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("ger", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("wete", "we", "reales", 4, 1234));

        root = arbol.insert(root, new Persona("ttt", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("ee", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("eff", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("eafas", "we", "reales", 4, 1234));

        Persona p = (Persona) root.getChildren().search(0).getInfo();
        System.out.println("hijos raíz:" + p.getUserName());
        Persona p1 = (Persona) root.getChildren().search(0).getChildren().search(0).getInfo();
        System.out.println("nieto raíz:" + p1.getUserName());
        Persona p2 = (Persona) root.getChildren().search(0).getChildren().search(1).getInfo();
        System.out.println("nieto raíz:" + p2.getUserName());
        Persona p3 = (Persona) root.getChildren().search(0).getChildren().search(2).getInfo();
        System.out.println("nieto raíz:" + p3.getUserName());
        Persona p4 = (Persona) root.getChildren().search(0).getChildren().search(3).getInfo();
        System.out.println("nieto raíz:" + p4.getUserName());
        Persona p5 = (Persona) root.getChildren().search(0).getChildren().search(4).getInfo();
        System.out.println("nieto raíz:" + p5.getUserName());

        root = arbol.insert(root, new Transaccion(12, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
//        
//        arbol.printArbol(root);

//        FileController fileCtrl = new FileController(arbol);
//        JoinController joinCtrl = new JoinController(arbol);
//        
//        fileCtrl.load();
//        joinCtrl.join();   
    }
}
