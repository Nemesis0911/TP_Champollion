package champollion;

public class ExceptionServiceDepasse extends Exception{

    private static final long serialVersionUID = 1L;

    public ExceptionServiceDepasse(UE ue) {
        super("nombre d'heures dépassées dans l'ue" +ue.getIntitule()) ;

    }
}
