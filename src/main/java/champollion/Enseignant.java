package champollion;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.Math ;
import java.util.Map;

/**
 * Un enseignant est caractérisé par les informations suivantes : son nom, son adresse email, et son service prévu,
 * et son emploi du temps.
 */
public class Enseignant extends Personne {


    Map<UE,ServicePrevu> listeHeure;
    Map<UE,Intervention> listeIntervention;

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.listeHeure = new HashMap<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {

        double total=0.0 ;
        for(ServicePrevu s : listeHeure.values() ) {
            total = total + (s.volumeCM*1.5) + (s.volumeTD) + (s.volumeTP*0.75) ;
        }

        return (int) Math.round(total);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {

        double total = 0.0;
        if(listeHeure.containsKey(ue)) {
            total = listeHeure.get(ue).volumeCM * 1.5 + listeHeure.get(ue).volumeTD + listeHeure.get(ue).volumeTP * 0.75;
        }
        return (int) Math.round(total);
    }

  /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magistral
     * @param volumeTD le volume d'heures de T
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, double volumeCM, double volumeTD, double volumeTP) {
        if(listeHeure.containsKey(ue)) {
            listeHeure.get(ue).volumeTP += volumeTP;
            listeHeure.get(ue).volumeTD += volumeTD;
            listeHeure.get(ue).volumeCM += volumeCM;
        }
        else {
            this.listeHeure.put(ue, new ServicePrevu(volumeCM, volumeTD, volumeTP));
        }
    }


    public void ajouteIntervention(Intervention i) throws ExceptionServiceDepasse{
        if(listeIntervention.containsKey(i.ue)) {
            //pas eu le temps de finir
        }
    }
}
