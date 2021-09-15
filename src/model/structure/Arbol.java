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

    public NodoArbol insert(NodoArbol root, Object info) {
        int i = 0;
        if (root.getInfo() == null) {
            System.out.println("raíz");
            NodoArbol p = new NodoArbol(2);
            p.setInfo("BLOCK-PAY");
            root = p;
            System.out.println("root: " + root.getInfo());
            root.addChild(root, new Persona("userFijo", "First", "User", 00000, 100000000), 4);
            root.addChild(root, new Bloque(1), 3);
        } else {
            if (info instanceof Persona) {
                NodoArbol p = root.getChildren().search(0);
                if (p.getChildren().search(0) == null) {
                    p.addChild(p, info);
                    System.out.println("por aca");
                } else {
                    NodoArbol q = p;
                    while (q.getNext() != null) {
                        q = q.getNext();
                    }
                    if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE()) {
                        System.out.println("entró");
                        insert(p, info);
                    } else {
                        System.out.println("sí");
                        p.addChild(p, info);
                    }
                }
//                
            } else if (info instanceof Transaccion) {
                NodoArbol p;
                if (root.getInfo() == "BLOCK-PAY") {
                    System.out.println("A");
                    p = root.getChildren().search(1);
                } else {
                    System.out.println("B");
                    p = root;
                }
                    if (p.getChildren().search(0) == null) {
                        p.addChild(p, info);
                        System.out.println("completado");
                    } else {
                        NodoArbol q = p;
                        while (q.getNext() != null) {
                            q = q.getNext();
                        }
                        if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() == null) {
                            System.out.println("en el if");
                            Bloque b = (Bloque) p.getInfo();
                            int j = (Integer) b.getInfo();
                            p.setNext(new NodoArbol(p, 3, new Bloque(j++)));
                            p = p.getNext();
                            insert(p, info);
                        } else if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() != null) {
                            System.out.println("if 2");
                            insert(p.getNext(), info);
                        } else {
                            System.out.println("va por el else");
                            p.addChild(p, info);
                        }
                    }

                }
            }
        return root;
    }
}

/**
if (root.getChildren().search(0) == null) {
//                    root.addChild(root, info, 6);
//                    System.out.println("1");
//                } else if (root.getChildren().search(0) != null && root.getChildren().getSize() <= root.getChildren().getMAX_SIZE()) {
//                    NodoArbol p;
//                    p = root.getChildren().search(0);
//                    int i = 0;
//                    while (p.getNext() != null) {
//                        p = p.getNext();
//                        i++;
//                    }
//                    if (i <= 2) {
//                        System.out.println("2");
//                        root.getChildren().search(i).addChild(root, info);
//                    } else {
//                        System.out.println("3");
//                        i = 0;
//                        insert(root.getChildren().search(0).getChildren().search(0), info);
//                    }
////                        root.getChildren().search(0).addChild(p.getDad(),info);
//                }
**/
//
//    public void printArbol(NodoLista l) {
//        if (l != null) {
//            System.out.println(l.getInfo().toString());
//        }
//    }
//
//    public void printArbol(NodoArbol a) {
//        System.out.println(a.getInfo());
//        if (a.getChildren().getSize() != 0) {
//            for (int i = 0; i < a.getChildren().getSize(); i++) {
//                printArbol(a.getChildren().search(i));
//            }
//        }
//    }
//
//    public NodoLista insertToChild(NodoLista rootA, NodoLista root, Object info, int letter, int pos) {
//        NodoLista temp = null;
//        if (letter == 1) {
//            if (rootA.getChildren().search(pos + 1) == null) {
//                temp = root;
//                temp.setInfo(info);
//                temp.setNext(null);
//                temp.setDad(rootA);
//                System.out.println("VALIDO");
//            } else {
//                System.out.println("acá");
//                temp = rootA.getChildren().search(pos + 1);
//                int cont = 0;
//                int i = temp.getDad().getChildren().getSize();
//                while (temp.getNext() == null || cont < i) {
//                    temp = temp.getNext();
//                    cont++;
//                }
//                if (cont == i) {
//                    pos++;
//                    insertToChild(rootA.getChildren().search(pos), root, info, letter, pos);
//                } else {
//                    System.out.println("OPS 2");
//                }
//            }
//        }
//        return rootA;
//    }
//
//    int i = 0;
//
//    public NodoArbol insert(NodoArbol root, Object info) {
//        if (root.getInfo() == null) {
//            NodoArbol rootTemp = new NodoArbol(2);
//            rootTemp.setInfo("BLOCK-PAY");
//            root = rootTemp;
//            root.addChild();
//            System.out.println("user");
//            root.addChild();
//            System.out.println("trans");
//        } else {
//            i++;
//            if (info instanceof Persona) {
//                if (i == 1) {
//                    NodoLista a = new NodoLista(root, 3, info);
//                    NodoLista b = root.getChildren().search(0);
//                    b = a;
//                    System.out.println(b.getInfo().toString());
////                } else {
////                    int i = 0;
////                    NodoLista p = root.getChildren().search(0);
////                    if (p.getChildren().search(i) != null) {
////                        while (p.getChildren().search(i).getNext() != null) {
////                            p = p.getChildren().search(i++).getNext();
////                        }
////                        root.addChild(insertToChild(root.getChildren().search(i), new NodoLista(3), info, 1, -1));
////                    } else {
////                        root.addChild(insertToChild(root.getChildren().search(i), new NodoLista(3), info, 1, -1));
////                    }
//                }
////                if (root.getChildren().search(0).getInfo() != null){
////                    System.out.println("axa");
////                } else if (root.getChildren().search(0).getInfo() == null) {
////                    System.out.println("2");
////                    NodoLista a = root.getChildren().search(0);
////                    NodoLista a2 = new NodoLista(root,3,info);
////                    a = a2;
////                    Persona p = (Persona)info;
////                    System.out.println(((Persona) info).getUserName());
////                } 
//            } else if (info instanceof Transaccion) {
//                if (i == 1) {
//                    NodoLista a = new NodoLista(root, 3, info);
//                    NodoLista b = root.getChildren().search(1);
//                    b = a;
//                    System.out.println(b.getInfo().toString());
//                }
//            }
//        }
//
//        //
////    public NodoLista findHoja(NodoLista root, NodoLista temp) {
////        for (int i = 0; i < root.getChildren().getSize(); i++) {
////            if (root.getChildren().search(i) != null) {
////                findHoja(root.getChildren().search(i), temp);
////            } else {
////                temp = root.getChildren().search(i);
////            }
////        }
////        return temp;
////    }
//        return root;
//    }
