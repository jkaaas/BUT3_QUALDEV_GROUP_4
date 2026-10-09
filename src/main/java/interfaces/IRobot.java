package interfaces;

import enumerations.EDirection;
import modele.Case;
import modele.Grille;

public interface IRobot {
    EDirection getSens();

    void setSens(EDirection sens);

    Case getCaseFinale();

    void setCaseFinale(Case caseFinale);

    Grille getGrille();
}