package model.system;

public class Transaccion {
    private int id;
    
    private float monto;
    private float remitenteAntes;
    private float remitenteDespues;
    private float destinatarioAntes;
    private float destinatarioDespues;
    
    private int remitenteId;
    private int destinatarioId;

    public Transaccion(int id, int remitenteId, int destinatarioId, float monto, float remitenteAntes, float remitenteDespues, float destinatarioAntes, float destinatarioDespues) {
        this.id = id;
        this.monto = monto;
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
        
        this.remitenteAntes = remitenteAntes;
        this.remitenteDespues = remitenteDespues;
        this.destinatarioAntes = destinatarioAntes;
        this.destinatarioDespues = destinatarioDespues;
    }

    public int getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }

    public int getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    
    public int getId() {
        return this.id;
    }

    public float getMonto() {
        return this.monto;
    }

    public float getRemitenteAntes() {
        return this.remitenteAntes;
    }

    public void setRemitenteAntes(float remitenteAntes) {
        this.remitenteAntes = remitenteAntes;
    }

    public float getRemitenteDespues() {
        return this.remitenteDespues;
    }

    public void setRemitenteDespues(float remitenteDespues) {
        this.remitenteDespues = remitenteDespues;
    }
    

    public float getDestinatarioAntes() {
        return this.destinatarioAntes;
    }

    public void setDestinatarioAntes(float destinatarioAntes) {
        this.destinatarioAntes = destinatarioAntes;
    }

    public float getDestinatarioDespues() {
        return this.destinatarioDespues;
    }

    public void setDestinatarioDespues(float destinatarioDespues) {
        this.destinatarioDespues = destinatarioDespues;
    }

}
