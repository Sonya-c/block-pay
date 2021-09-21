package controller;

import java.io.File;
import model.structure.Arbol;
import model.system.Persona;
import model.system.Transaccion;
import view.Dialog;

public class TransaccionController {

    private Arbol arbol;
    private FileController registro;

    public TransaccionController(Arbol arbol) {
        this.arbol = arbol;
        this.registro = new FileController(arbol);
        System.out.println(arbol.getRoot());
    }

    public Arbol getArbol() {
        return arbol;
    }

    public int transaccion(int remitenteID, int destinatarioID, float monto) {
        File f = new File("C:\\Block-Pay\\registrosTransacciones.txt");
        File f2 = new File("C:\\Block-Pay\\registrosUsuarios.txt");
        
        registro.searchOrCreateFile(f, "registrosTransacciones.txt");
        registro.searchOrCreateFile(f2, "registrosUsuarios.txt");
                
        if (arbol.verificarMontoRemitente(arbol.getRoot(), remitenteID, monto)) {
        
            int ID = (int) (Math.random() * (54321 - 1 + 1) + 1);
            
            while (registro.searchInFile(f, ID)) {
                ID = (int) (Math.random() * (54321 - 1 + 1) + 1);
            }
            
            Persona remitente = arbol.searchUser(arbol.getRoot().getChildren().search(0), remitenteID, 0);
            Persona destinatario = arbol.searchUser(arbol.getRoot().getChildren().search(0), destinatarioID, 0);
            
            if (remitente != null && destinatario != null) {    
                if (remitente.getDinero() >= monto) {
                    
                    
                    remitente.setDinero(remitente.getDinero() - monto);
                    destinatario.setDinero(destinatario.getDinero() + monto);
                    
                    // ALERTA: ESTAFA PIRAMIDAL!!!
                    // arbol.searchUser(arbol.getRoot().getChildren().search(0), remitente, remitente.getDinero() - monto, 0);
                    // arbol.searchUser(arbol.getRoot().getChildren().search(0), destinatario, destinatario.getDinero() + monto, 0);
                    
                    float remitenteAntes = remitente.getDinero();
                    float remitenteDespues = remitente.getDinero() - monto;
                    float destinatarioAntes = destinatario.getDinero();
                    float destinatarioDespues = destinatario.getDinero() + monto;
                    
                    registro.updateCash(f2, destinatarioDespues, destinatario.getUserName());
                    registro.updateCash(f2, remitenteDespues, remitente.getUserName());
                    
                    Transaccion t = new Transaccion(ID, remitenteID, destinatarioID, monto, remitenteAntes, remitenteDespues, destinatarioAntes, destinatarioDespues);
                    registro.wirteFile(f, t);
                    arbol.insert(arbol.getRoot().getChildren().search(1), t);
                    
                } else {
                    Dialog dialog = new Dialog();
                    dialog.setMessage("No tiene dinero en su cuenta disponible para la transacción");
                }
            }
        }
        
        return -1;
    }
    /*
    public void transaccion(int remitenteID, int emisarioID, float monto) {
        File f = new File("C:\\Block-Pay\\registrosTransacciones.txt");
        File f2 = new File("C:\\Block-Pay\\registrosUsuarios.txt");
        
        registro.searchOrCreateFile(f, "registrosTransacciones.txt");
        registro.searchOrCreateFile(f2, "registrosUsuarios.txt");
        
        
        
        if (arbol.verificarMontoRemitente(arbol.getRoot(), remitenteID, monto)) {
        
            int iD = (int) (Math.random() * (54321 - 1 + 1) + 1);
            
            while (registro.searchInFile(f, iD)) {
                iD = (int) (Math.random() * (54321 - 1 + 1) + 1);
            }
            
            Persona remitente = arbol.searchUser(arbol.getRoot().getChildren().search(0), remitenteID, 0);
            Persona destinatario = arbol.searchUser(arbol.getRoot().getChildren().search(0), emisarioID, 0);
            
            if (remitente.getDinero() >= monto) {
                Transaccion t = new Transaccion(iD, remitente, destinatario, monto);
                registro.wirteFile(f, t);
                arbol.insert(arbol.getRoot().getChildren().search(1), t);
                remitente.setDinero(remitente.getDinero() - monto);
                destinatario.setDinero(destinatario.getDinero() + monto);
                arbol.searchUser(arbol.getRoot().getChildren().search(0), remitente, remitente.getDinero() - monto, 0);
                arbol.searchUser(arbol.getRoot().getChildren().search(0), destinatario, destinatario.getDinero() + monto, 0);
                registro.updateCash(f2, destinatario.getDinero() + monto, destinatario.getUserName());
                registro.updateCash(f2, remitente.getDinero() - monto, remitente.getUserName());
            } else {
                Dialog dialog = new Dialog();
                dialog.setMessage("No tiene dinero en su cuenta disponible para la transacción");
            }
        }
    }*/
}
