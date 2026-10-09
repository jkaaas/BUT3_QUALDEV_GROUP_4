package start;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;
import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;

import java.util.List;

import exceptions.DeplacementException;
import manager.TondeuseManager;
import modele.Grille;
import modele.Tondeuse;

public class DemarreTondeuse {

    public static void main(String[] args) {
        Grille pelouse = new Grille(5, 5);
        Tondeuse tondeuse1 = new Tondeuse(5, 5, 1, 2, NORTH);
        Tondeuse tondeuse2 = new Tondeuse(5, 5, 3, 3, EAST);
        try {
            // TODO : Lire un fichier qui contient la séquence et qui l'exécute.
            TondeuseManager manager1 = new TondeuseManager(tondeuse1, pelouse);
            manager1.executer(List.of(G, A, G, A, G, A, G, A, A));
            System.out.println(tondeuse1);

            TondeuseManager manager2 = new TondeuseManager(tondeuse2, pelouse);
            manager2.executer(List.of(A, A, D, A, A, D, A, D, D, A));
            System.out.println(tondeuse2);
        } catch (DeplacementException e) {
            System.out.println(e.getMessage());
        }
    }

}