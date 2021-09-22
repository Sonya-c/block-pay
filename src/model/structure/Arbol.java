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

    /**
     * Compara si la información de una persona es la misma
     *
     * @param nodo
     * @param info
     * @return
     */
    public boolean compareInfoInArbol(NodoArbol nodo, Object info) {
        if (nodo.getInfo() == null) {
            return true;
        } else if (info instanceof Persona) {

            Persona infoNodo = (Persona) nodo.getInfo();
            infoNodo = (Persona) infoNodo;
            Persona infoObj = (Persona) info;

            return infoNodo.getUserName().equals(infoObj.getUserName()) && infoNodo.getNames().equals(infoObj.getUserName())
                    && infoNodo.getLastNames().equals(infoObj.getLastNames()) && infoNodo.getId() == infoObj.getId()
                    && infoNodo.getDinero() == infoObj.getDinero();
        }
        return false;
    }

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

    public NodoArbol searchUser(NodoArbol root, Persona user, float newInfo, int i) {
        if (root.getInfo() != null) {
            System.out.println("hola");
            Persona info = (Persona) root.getInfo();
            if (confirmation(info, user)) {
                System.out.println("ya");
                modifyInfo(root, newInfo);
                return root;
            } else {
                if (root.getChildren() != null) {
                    NodoArbol q = root.getChildren().search(0);
                    info = (Persona) q.getInfo();
                    while (i <= 3) {
                        System.out.println(i);
                        q = root.getChildren().search(i++);
                        info = (Persona) q.getInfo();
                        if (confirmation(info, user)) {
                            modifyInfo(q, newInfo);
                            return q;
                        }
                    }
                    root = searchUser(root.getChildren().search(0), user, newInfo, 0);
                }
            }
        }
        return root;
    }

    public float verificarMonto(NodoArbol bloque, int id, float montoAcum) {
        Transaccion t;
        Persona remitente = this.searchUser(getRoot().getChildren().search(0), id, 0);
        int i = 0;
        while (i <= 2) {
            if (bloque.getChildren().search(i) != null) {
                t = (Transaccion) bloque.getChildren().search(i).getInfo();

                if (remitente != null && id == remitente.getId()) {
                    montoAcum -= t.getMonto();
                } else if (remitente != null && id == t.getDestinatarioId()) {
                    montoAcum += t.getMonto();
                }

                System.out.println(montoAcum);

            } else {
                return montoAcum;
            }
            i++;
        }
        return montoAcum;
    }

    public boolean verificarMontoRemitente(NodoArbol root, int id, float monto) {
        Persona p = this.searchUser(root.getChildren().search(0), id, 0);
        float saldo = 0f;
        NodoArbol q = root.getChildren().search(1);
        saldo += this.verificarMonto(q, id, 50000);
        while (q.getNext() != null) {
            saldo += this.verificarMonto(q, id, 50000);
            q = q.getNext();
        }
        return saldo <= p.getDinero();
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
            root.addChild(root, new Bloque(1, 3), 3);
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
    public NodoArbol insert(NodoArbol root, Object info) {

        if (info instanceof Persona) {
            NodoArbol p = root.getChildren().search(0);
            System.out.println("model.struture.Arbol.insert > insertando persona p " + p);
            if (p.getChildren().search(0) == null) {

                p.addChild(p, info);
                System.out.println("model.strucure.Arbol.insert > insertando persona, no hay hijo");

            } else {

                if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE()) {
                    System.out.println("model.strucure.Arbol.insert > insertando persona insertar nuevo nodo");
                    insert(p, info);

                } else {
                    System.out.println("model.strucure.Arbol.insert > insertando persona añadir hijo");
                    p.addChild(p, info);
                }
            }
        } else if (info instanceof Transaccion) {
            NodoArbol p = root.getChildren().search(1);
            if (p.getInfo() instanceof Bloque) {
                NodoArbol q = p.getChildren().search(0);
                int i = 0;
                while (q != null && i <= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()
                        && ((Bloque) p.getInfo()).getTransaccionesAct() <= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()) {
                    System.out.println("valor de i = " + i);
                    q = p.getChildren().search(i++);
                }
                if (q == null && ((Bloque) p.getInfo()).getTransaccionesAct() < ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()) {
                    p.addChild(p, info);
                    ((Bloque) p.getInfo()).setTransaccionesAct();
                    System.out.println("transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
                    System.out.println("Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
                } else if (i >= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS() && p.getNext() != null) {
                    p = p.getNext();
                    System.out.println("Se va al otro bloque");
                    p.addChild(p, info);
//                    root = insertTrans(p, info);
                    ((Bloque) p.getInfo()).setTransaccionesAct();
                    System.out.println("transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
                    System.out.println("Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
                } else if (i >= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS() && p.getNext() == null) {
                    Bloque b = new Bloque(((Bloque) p.getInfo()).getInfoBloque() + 1, 3);
                    p.setNext(new NodoArbol());
                    p.getNext().setInfo(b);
                    p = p.getNext();
                    System.out.println("Se creó el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
                    insert(root, info);
                }
            }

//            if (p.getChildren().search(0) == null) {
//                p.addChild(p, info);
//                System.out.println("model.struture.Arbol.insert > insertada transacción primera de bloque " + p);
//            } else {
//                if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() == null) {
//                    Bloque b = (Bloque) p.getInfo();
//                    int j = (Integer) b.getInfo();
//                    Bloque bloque = new Bloque(j++, 3);
//                    p.setNext(new NodoArbol(p, 3, bloque));
////                    p = p.getNext();
//                    System.out.println(j);
//                    System.out.println("model.struture.Arbol.insert > insertando bloque p " + p);
//                    insert(root, info);
//                } else if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() != null) {
//                    System.out.println("model.struture.Arbol.insert > insertando transacción p en el siguiente bloque " + p);
//                    insert(p, info);
//                } else {
//                    System.out.println("model.struture.Arbol.insert > insertando transacción p " + p);
//                    p.addChild(p, info);
//                }
//            }
//          
//    Bloque p = (Bloque)root.getChildren().search(1);
//            Bloque p = (Bloque) root;
//            if (p instanceof Bloque) {
//                NodoArbol q = p.getChildren().search(0);
//                int i = 0;
//                while (q != null && i <= ((Bloque) p).getTRANSACCIONES_MAXIMAS()) {
//                    q = p.getChildren().search(i++);
//                }
//                if (q == null) {
//                    p.addChild(p, info);
//                    p.setTransaccionesAct();
//                } else if (i == ((Bloque) p).getTRANSACCIONES_MAXIMAS()) {
//                    Bloque b = new Bloque(p.getInfoBloque() + 1, 3);
//                    p.setNext(b);
//                    p = (Bloque) p.getNext();
//                    this.insert(p, info);
//                }
        }
        return root;
    }
//    
//    public boolean verifyChild(NodoArbol nodo){
//        int i = 0;
//        NodoArbol p = nodo.getChildren().search(0);
//        while (p != null && i <= 3){
//            p = nodo.getChildren().search(i++);
//        }
//        if (nodo.getNext() == null){
//            return false;
//        } else if (nodo.getNext() != null){
//            verifyChild(nodo.getNext());
//        }
//    }
//
//    public NodoArbol insertTrans(NodoArbol root, Object info) {
//        System.out.println("Llegó acá");
//        NodoArbol p = root;
//        if (p.getInfo() instanceof Bloque) {
//            NodoArbol q = p.getChildren().search(0);
//            int i = 0;
//            while (q != null && i <= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()
//                    && ((Bloque) p.getInfo()).getTransaccionesAct() <= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()) {
//                System.out.println("valor de i = " + i);
//                q = p.getChildren().search(i++);
//            }
//            if (q == null && ((Bloque) p.getInfo()).getTransaccionesAct() < ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS()) {
//                p.addChild(p, info);
//                ((Bloque) p.getInfo()).setTransaccionesAct();
//                System.out.println("transacciones actuales en el bloque: " + ((Bloque) p.getInfo()).getTransaccionesAct());
//                System.out.println("Se agregó en el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
//            } else if (i >= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS() && p.getNext() == null) {
//                Bloque b = new Bloque(((Bloque) p.getInfo()).getInfoBloque() + 1, 3);
//                p.setNext(new NodoArbol());
//                p.getNext().setInfo(b);
//                p = p.getNext();
//                System.out.println("Se creó el bloque " + ((Bloque) p.getInfo()).getInfoBloque());
//                insertTrans(root, info);
//            } else if (i >= ((Bloque) p.getInfo()).getTRANSACCIONES_MAXIMAS() && p.getNext() != null) {
//                p = p.getNext();
//                System.out.println("Se va al otro bloque");
//                insertTrans(p, info);
//            }
//        }
//        return root;
//    }
}
