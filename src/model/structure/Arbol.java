package model.structure;

import model.structure.nodo.NodoArbol;
import model.system.Bloque;
import model.system.Persona;
import model.system.Transaccion;

public class Arbol {

    private NodoArbol root;

    public Arbol() {
        this.root = new NodoArbol();

    }

    public Arbol(int N) {
        this.root = new NodoArbol(N);
    }

    public void add() {
        root.addChild(this.root);
    }

    public void add(Object info, NodoArbol dad) {
        root.addChild(dad, info);
    }

    public NodoArbol getRoot() {
        return this.root;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }

//    /**
//     * Compara si la información de una persona es la misma
//     *
//     * @param nodo
//     * @param info
//     * @return
//     */
//    public boolean compareInfoInArbol(NodoArbol nodo, Object info) {
//        if (nodo.getInfo() == null) {
//            return true;
//        } else if (info instanceof Persona) {
//
//            Persona infoNodo = (Persona) nodo.getInfo();
//            infoNodo = (Persona) infoNodo;
//            Persona infoObj = (Persona) info;
//
//            return infoNodo.getUserName().equals(infoObj.getUserName()) && infoNodo.getNames().equals(infoObj.getUserName())
//                    && infoNodo.getLastNames().equals(infoObj.getLastNames()) && infoNodo.getId() == infoObj.getId()
//                    && infoNodo.getDinero() == infoObj.getDinero();
//        }
//        return false;
//    }

    public boolean confirmation(Persona info1, Persona info2) {
        return info1.getUserName().equals(info2.getUserName());
    }

    public boolean confirmation(String user1, String user2) {
        System.out.println("controller.FileController.confirmation user1 = " + user1 + " // user2 = " + user2);
        return user1.equals(user2);
    }

    public boolean confirmation(int id1, int id2) {
        return id1 == id2;
    }

    public Persona searchUser(NodoArbol root, int id, int i) {
        Persona info = null;

        if (root.getInfo() != null) {
            System.out.println("mode.structure.Arbol.searchUser(NodoArbol, int, int) Información no vacia");
            info = (Persona) root.getInfo();

            if (confirmation(info.getId(), id)) {
                System.out.println("mode.structure.Arbol.searchUser(NodoArbol, int, int) confirmación true");
                return info;
            } else {
                if (root.getChildren() != null) {
                    NodoArbol q = root;
                    info = (Persona) q.getInfo();

                    while (root.getChildren() != null && i <= root.getChildren().getSize()) {
                        System.out.println("model.structure.Arbol.searchUser: i = " + i);
                        NodoArbol nodo = root.getChildren().search(i);

                        if (nodo != null) {
                            info = (Persona) nodo.getInfo();

                            if (confirmation(info.getId(), id)) {
                                return info;
                            }
                        }
                        i++;
                    }
                    System.out.println("mode.structure.Arbol.searchUser(NodoArbol, int, int) SALIÓ");
                    info = searchUser(root.getChildren().search(0), id, 0);
                }
            }
        }
        return info;
    }

    public Persona searchUser(NodoArbol root, String user, int i) {
        Persona info = null;

        if (root != null && root.getInfo() != null) {
            info = (Persona) root.getInfo();
            System.out.println("model.structure.Arbol.searchUser: root info <> null; info (user name) = " + info.getUserName());

            System.out.println(confirmation(info.getUserName(), user));
            if (confirmation(info.getUserName(), user)) {
                System.out.println("model.structure.Arbol.searchUser: es el usuario");
                return info;

            } else {

                while (root.getChildren() != null && i <= root.getChildren().getSize()) {
                    System.out.println("model.structure.Arbol.searchUser: i = " + i);
                    NodoArbol nodo = root.getChildren().search(i);

                    if (nodo != null) {
                        info = (Persona) nodo.getInfo();

                        if (confirmation(info.getUserName(), user)) {
                            return info;
                        }
                    }
                    i++;
                }

                info = searchUser(root.getChildren().search(0), user, 0);
            }
        }
        return info;
    }

    public NodoArbol searchUser(NodoArbol root, Persona user, Persona newInfo, int i) {
        Persona info;
        if (root != null && root.getInfo() != null) {
            info = (Persona) root.getInfo();
            System.out.println("model.structure.Arbol.searchUser: root info <> null; info (user name) = " + info.getUserName());

            if (confirmation(info.getUserName(), user.getUserName())) {
                System.out.println("model.structure.Arbol.searchUser: es el usuario");
                root.setInfo(newInfo);
            } else {

                while (root.getChildren() != null && i <= root.getChildren().getSize()) {
                    System.out.println("model.structure.Arbol.searchUser: i = " + i);
                    NodoArbol nodo = root.getChildren().search(i);

                    if (nodo != null) {
                        info = (Persona) nodo.getInfo();

                        if (confirmation(info.getUserName(), user.getUserName())) {
                            nodo.setInfo(newInfo);
                        }
                    }
                    i++;
                }
            }
        }
        return root;
    }

    /**
     * 
     * @param bloque
     * @param user
     * @param montoAcum
     * @return 
     */
    public float verificarMonto(NodoArbol bloque, Persona user, float montoAcum) {
        Transaccion t;
        int i = 0;
        
        while (i <= ((Bloque) bloque.getInfo()).getTransaccionesAct()) {
            NodoArbol p = bloque.getChildren().search(i);
            
            if (p != null) {
                t = (Transaccion) p.getInfo();
                System.out.println("model.structure.Arbol.verificarMonto transacción del nodo p: " + t);
                
                if (user.getId() == t.getRemitenteId()) {
                    montoAcum -= t.getMonto();
                } else if (user.getId() == t.getDestinatarioId()) {
                    montoAcum += t.getMonto();
                }

                System.out.println("model.structure.Arbol.verificarMonto Monto acumulado: " + montoAcum);
                System.out.println("model.structure.Arbol.verificarMonto Número del bloque actual: " + ((Bloque)bloque.getInfo()).getInfoBloque());
            }
            i++;
            System.out.println("lmodel.structure.Arbol.verificarMonto a iteración número: " + i);
        }
        return montoAcum;
    }
    
    /**
     * 
     * @param root
     * @param id
     * @param monto
     * @return 
     */
    public boolean verificarMontoRemitente(NodoArbol root, int id, float monto) {
        Persona p = this.searchUser(root.getChildren().search(0), id, 0);
        float saldo = 50000;
       
        NodoArbol q = root.getChildren().search(1); // Raíz del subarbol de personas
        
        saldo = this.verificarMonto(q, p, saldo);
        q = q.getNext();
    
        while (q != null) {
            saldo = this.verificarMonto(q, p, saldo);
            q = q.getNext();
        }
        
        System.out.println("Saldo en papel " + p.getDinero() + " vs Saldo calculado :" + saldo);
        return saldo == p.getDinero();
    }

    public Persona modifyInfo(NodoArbol nodo, float info) {
        Persona p = (Persona) nodo.getInfo();
        System.out.println(p.getDinero());
        p.setDinero(p.getDinero() + info);
        System.out.println(p.getDinero());
        return p;
    }

    public NodoArbol insertRoot(NodoArbol root, Object info) {
        if (root.getInfo() == null) {
            System.out.println("raíz");
            NodoArbol p = new NodoArbol(2);
            p.setInfo("BLOCK-PAY");
            root = p;
            System.out.println("root: " + root.getInfo());
            root.addChild(root, new Persona("userFijo", "First", "User", 00000, 100000000, "***"));
            root.addChild(root, new Bloque(1,3));
        }
        return root;
    }

    /**
     * Inserta un nodo
     *
     * @param root
     * @param info
     * @return
     */
    public NodoArbol insertPersona(NodoArbol root, Persona info) {

        NodoArbol p = root.getChildren().search(0);
        System.out.println("model.struture.Arbol.insert > insertando persona p " + p);
        if (p.getChildren().search(0) == null) {

            p.addChild(p, info);
            System.out.println("model.strucure.Arbol.insert > insertando persona, no hay hijo");

        } else {

            if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE()) {
                System.out.println("model.strucure.Arbol.insert > insertando persona insertar nuevo nodo");
                insertPersona(p, info);

            } else {

                System.out.println("model.strucure.Arbol.insert > insertando persona añadir hijo");
                p.addChild(p, info);

            }

        }
        return root;
    }
 
    public NodoArbol insertTrans(NodoArbol root, Transaccion info, int j) {
        NodoArbol p = root.getChildren().search(1);

        if (p.getInfo() instanceof Bloque) {
            // Buscar un bloque que este disponible o llegar hasta el último
            while (p.getNext() != null && p.getChildren().getSize() == 3) {
                p = p.getNext();
                System.out.println("model.system.Bloque.insertTrans Bajando de bloque");
            }

            if (p.getNext() == null && p.getChildren().getSize() == 3) {
                // No hay bloques vacios, toca crear uno

                Bloque b = new Bloque(((Bloque) p.getInfo()).getInfoBloque() + 1, 3);
                                
                // Al ultimo bloque añadirle el nuevo bloque
                NodoArbol nodoArbol = new NodoArbol(3);
                nodoArbol.setInfo(b);
                p.setNext(nodoArbol);
                
                // Añadir esta nueva transacción al bloque
                nodoArbol.addChild(p, info);
                b.addChild(p, info);
                ((Bloque) p.getInfo()).setTransaccionesAct();
                
                
                System.out.println("model.system.Bloque.insertTrans transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
                System.out.println("model.system.Bloque.insertTrans Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());

            } else if (p.getNext() == null && p.getChildren().getSize() < 3) {
                // Hay un bloque disponible
                p.addChild(p, info);
                
                ((Bloque) p.getInfo()).setTransaccionesAct();
                System.out.println("model.system.Bloque.insertTrans transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
                System.out.println("model.system.Bloque.insertTrans Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
                
                for (int z = 0; z <= p.getChildren().getSize(); z++) {
                    System.out.println(p.getChildren().search(z));
                }
                
            }
        }

        return root;
    }
//  public NodoArbol insertTrans(NodoArbol root, Transaccion info, int j) {
//        NodoArbol p;
//        if (j == 0) {
//            p = root.getChildren().search(1);
//        } else {
//            p = root;
//        }
//        System.out.println(p.getInfo() instanceof Bloque);
//        if (p.getInfo() instanceof Bloque) {
//            if (p.getChildren().getSize() < 3) {
//                System.out.println(((Bloque) p.getInfo()).getTransaccionesAct() <= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS());
//                NodoArbol q = p.getChildren().search(0);
//                System.out.println("¿q!=null? = " + q);
//                int i = 0;
//                while (q != null && i <= 3) {
//                    System.out.println("valor de i = " + i);
//                    q = p.getChildren().search(i++);
//                }
//                if (q == null && ((Bloque) p.getInfo()).getTransaccionesAct() < ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()) {
//                    p.addChild(p, info);
//                    ((Bloque) p.getInfo()).setTransaccionesAct();
//                    System.out.println("transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
//                    System.out.println("Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
//                }
//            } else {
//                System.out.println("EN EL HPTA ELSE");
//                while (p.getNext() != null && p.getChildren().getSize() == 3) {
//                    p = p.getNext();
//                    System.out.println("Bajando de bloque");
//                }
//                if (p.getNext() == null && p.getChildren().getSize() == 3) {
//                    Bloque b = new Bloque(((Bloque) p.getInfo()).getInfoBloque() + 1, 3);
//                    p.setNext(new NodoArbol());
//                    p.getNext().setInfo(b);
//                    p = p.getNext();
//                    p.addChild(p, info);
//                    System.out.println("Se creó el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
//                    ((Bloque) p.getInfo()).setTransaccionesAct();
//                    System.out.println("transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
//                    System.out.println("Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
//                } else if (p.getNext() == null && p.getChildren().getSize() < 3) {
//                    System.out.println("en este bloque");
//                    System.out.println(p.getInfo());
//                    p.addChild(p, info);
//                    ((Bloque) p.getInfo()).setTransaccionesAct();
//                    System.out.println("transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
//                    System.out.println("Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
//                }
//            }
//        }
//
//        return root;
//    }
}
