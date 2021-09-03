package model.system;

public class Transaccion {
    private final int id;
    private final Persona remitente;
    private final Persona destinatario;
    private final float monto;

    private float remitenteAntes;
    private float remitenteDespues;
    private float destinatarioAntes;
    private float destinatarioDespues;

    public Transaccion(int id, Persona remitente, Persona destinatario, float monto) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.monto = monto;
    }


    public int getId() {
        return this.id;
    }


    public Persona getRemitente() {
        return this.remitente;
    }


    public Persona getDestinatario() {
        return this.destinatario;
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
