
package model.structure;

public class Arbol {
    private NodoArbol root;

    public Arbol() {
        this.root = new NodoArbol();
    }

    public Arbol(int N) {
        this.root = new NodoArbol(N);
    }
    
    public void add(Object info) {
        root.add(info);
    }
    
//    
//    public void addToArbol(NodoArbol na){
//        if (root == null){
//            return;
//        } else {
//            if(na.getChildren().getSize() == root.getChildren().getMAX_SIZE()){
//                addToArbol (na.getChildren().)
//            }
//        }
//        
//    }
    
}
