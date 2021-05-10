package bomber.views;

public final class BasicExitAlertBox extends ExitAlertBox{
    
    /* Methods. */
    public boolean display() {
        return super.display("Chiudere il gioco", "Sei sicuro di voler chiudere il gioco?\n"
                + "Tutti i progessi non salvati andranno persi", "Chiudi", "Annulla");
    }
}
