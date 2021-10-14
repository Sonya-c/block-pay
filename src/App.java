import model.dynamic.list.ListNode;
import model.system.Account;
import model.structure.graph.Graph;
import view.LoginView;

/**
 *
 * @author sonya
 */
public class App {
    
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        
        g.addNodeUser(new Account("1","NATSLIA","FFF","FS"));
        for (Object object : g.getMainNode()) {
            System.out.println(object.toString());
        }
        ListNode l = g.getMainNode().getNode("Usuarios");
        while(l != null){
            System.out.println(l.getInfo());
            l = l.getDown();
            System.out.println(l);
        }
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
