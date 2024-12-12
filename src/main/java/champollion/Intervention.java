package champollion;

import java.util.Date;

public class Intervention {

    protected Date debut;
    protected int duree;
    protected boolean annulee = false;
    protected int heureDebut;
    protected TypeIntervention type;
    protected UE ue;
    public Intervention(Date debut, int duree, boolean annulee, int heureDebut, TypeIntervention type, UE ue) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.type = type;
        this.ue = ue;
    }

}
