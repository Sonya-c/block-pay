
import model.structure.Arbol;
import controller.FileController;
import controller.JoinController;
import java.io.File;
import model.structure.nodo.NodoArbol;
import model.system.Bloque;
import model.system.Persona;
import model.system.Transaccion;

public class App {

    public static void main(String[] args) {
         Arbol arbol = new Arbol(2);
        NodoArbol root = arbol.getRoot();

        FileController registro = new FileController(arbol);
        File f = new File("C:\\Block-Pay\\registrosUsuarios.txt");
        File f2 = new File("C:\\Block-Pay\\registrosTransacciones.txt");
        registro.searchOrCreateFile(f, "registrosUsuarios.txt");
        registro.searchOrCreateFile(f2, "registrosTransacciones.txt");
        if (!registro.searchInFile(f, "userFijo")) {
            registro.writeFile(f, new Persona("userFijo", "First", "User", 0, 1000000000), "***");
        }
        root = registro.uploadUsers(f, f2,root);
        arbol.setRoot(root);
        System.out.println("ACÁ LA TRANS" + root.getChildren().search(1).getChildren().search(0));
//        
        Persona p = (Persona) root.getChildren().search(0).getChildren().search(0).getChildren().search(0).getChildren().search(2).getInfo();
        System.out.println(p.getUserName());
        Persona z = arbol.searchUser(root.getChildren().search(0), "jmendoza",0);
        System.out.println(z.getId());
        
        
        FileController fileCtrl = new FileController(arbol);
        JoinController joinCtrl = new JoinController(arbol);

        fileCtrl.load();
        joinCtrl.join();

    }
}





/*
root = arbol.insert(root, 0);
        root = arbol.insert(root, new Persona("kelly", "kelly", "reales", 4, 1234));
//        root = arbol.insert(root, new Persona("ger", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("wete", "we", "reales", 4, 1234));

        root = arbol.insert(root, new Persona("ttt", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("ee", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("ee", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("aaa", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("eedd", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("eff", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("eafas", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Persona("eafs", "we", "reales", 4, 1234));
        root = arbol.insert(root, new Transaccion(12, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(11, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(11, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(11, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(10, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(9, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(2, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(122, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
        root = arbol.insert(root, new Transaccion(1, new Persona("kelly", "kelly", "reales", 4, 1234), new Persona("eafas", "we", "reales", 4, 1234), 13000));
//        Bloque b = (Bloque) root.getChildren().search(1).getNext().getInfo();
//        System.out.println(b.getPrev().getInfo());
//        Transaccion t = (Transaccion) root.getChildren().search(1).getNext().getChildren().search(0).getInfo();

//        System.out.println(t.getId());
//        System.out.println(root.getChildren().search(1).getInfo().toString());
//        
//        Persona p = (Persona) root.getChildren().search(0).getInfo();
//        System.out.println("hijos raíz:" + p.getUserName());
//        Persona p1 = (Persona) root.getChildren().search(0).getChildren().search(0).getInfo();
//        System.out.println("nieto raíz:" + p1.getUserName());
//        Persona p2 = (Persona) root.getChildren().search(0).getChildren().search(1).getInfo();
//        System.out.println("nieto raíz:" + p2.getUserName());
//        Persona p3 = (Persona) root.getChildren().search(0).getChildren().search(2).getInfo();
//        System.out.println("nieto raíz:" + p3.getUserName());
//        Persona p4 = (Persona) root.getChildren().search(0).getChildren().search(3).getInfo();
////        System.out.println("nieto raíz:" + p4.getUserName());
////        Persona p5 = (Persona) root.getChildren().search(0).getChildren().search(4).getInfo();
////        System.out.println("nieto raíz:" + p5.getUserName());
//
////        Bloque b = (Bloque)root.getChildren().search(1).getInfo();
////        System.out.println(b.getChildren().search(0).getInfo());
//        
//        arbol.printArbol(root);
*/
