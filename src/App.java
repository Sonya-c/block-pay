import model.system.Account;
import model.system.Graph;
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
g.getMainNode();
        
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
