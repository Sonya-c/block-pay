
import model.structure.Arbol;
import controller.FileController;
import controller.JoinController;
import model.structure.nodo.NodoArbol;
import model.system.Bloque;
import model.system.Persona;
import model.system.Transaccion;

public class App {

    public static void main(String[] args) {
        // Creación del arbol que creara las personas 
        Arbol arbol = new Arbol(2);

        // Crear y leer los achivos
        FileController fileCtrl = new FileController(arbol, "C:\\Block-Pay\\", "registrosUsuarios.txt", "registrosTransacciones.txt");
        fileCtrl.init();
        Persona p = (Persona) arbol.getRoot().getChildren().search(0).getChildren().search(0).getChildren().search(1).getInfo();
        System.out.println(p.getUserName());
        // Abrir la pestaña de Join para que el usuario entre
        JoinController joinCtrl = new JoinController(arbol);
        joinCtrl.join();
//        
    NodoArbol b = arbol.getRoot().getChildren().search(1).getNext().getNext().getNext().getNext();
        System.out.println(((Bloque)b.getInfo()).getInfoBloque() + "  -  " + b.getChildren().getSize() + "  -  " + ((Bloque)b.getInfo()).getTransaccionesAct());
        
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
