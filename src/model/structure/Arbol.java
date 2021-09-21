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
                    NodoArbol q = root.getChildren().search(0);
                    info = (Persona) q.getInfo();
                    
                    while (i <= 3) {
                        System.out.println("mode.structure.Arbol.searchUser(NodoArbol, int, int) bucle i = " + i);
                        q = root.getChildren().search(i++);
                        
                        info = (Persona) q.getInfo();
                        if (confirmation(info.getId(), id)) {
                            return info;
                        }
                    }
                    
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
                
                while (root.getChildren() != null && i <= 3) {
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
        
        int i = 0;
        while (i <= 2) {
            if (bloque.getChildren().search(i) != null) {
                t = (Transaccion) bloque.getChildren().search(i).getInfo();
                Persona remitente = this.searchUser(getRoot().getChildren().search(0), t.getRemitenteId(), 0);

                if (remitente != null && id == remitente.getId()) {
                    montoAcum += t.getMonto();
                }
            }
            i++;
        }
        return montoAcum;
    }

    public boolean verificarMontoRemitente(NodoArbol root, int id, float monto) {
        Persona p = this.searchUser(root.getChildren().search(0), id, 0);
        float saldo = 0f;
        NodoArbol q = root.getChildren().search(1);
        saldo += this.verificarMonto(q, id, 0);
        while (q.getNext() != null) {
            saldo += this.verificarMonto(q, id, 0);
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
            root.addChild(root, new Persona("userFijo", "First", "User", 00000, 100000000,"***"));
            root.addChild(root, new Bloque(1), 3);
        }
        return root;
    }

    /**
     * Inserta un nodo
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
            if (p.getChildren().search(0) == null) {
                p.addChild(p, info);
                System.out.println("completado");
            } else {
                if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() == null) {
                    System.out.println("en el if");
                    Bloque b = (Bloque) p.getInfo();
                    int j = (Integer) b.getInfo();
                    p.setNext(new NodoArbol(p, 3, new Bloque(j++)));
                    p = p.getNext();
                    insert(root, info);
                    System.out.println(j);
                } else if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() != null) {
                    System.out.println("if 2");
                    insert(p, info);
                } else {
                    System.out.println("va por el else");
                    p.addChild(p, info);
                }
            }

        }
        return root;
    }
}