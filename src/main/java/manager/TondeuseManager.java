package manager;

import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;
import static enumerations.EDirection.SOUTH;
import static enumerations.EDirection.WEST;

import java.util.List;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;
import interfaces.IRobot;
import modele.Grille;

public class TondeuseManager {

    private IRobot robot;
    private Grille pelouse;

    public TondeuseManager(IRobot robot, Grille pelouse) {
        this.robot = robot;
        this.pelouse = pelouse;
    }

    public void executer(List<EDeplacement> sequence) throws DeplacementException {
        for (EDeplacement deplacement : sequence) {
            this.deplacement(deplacement);
        }
    }

    public void deplacement(EDeplacement deplacement) throws DeplacementException {
        EDirection sens = this.robot.getSens();
        switch (deplacement) {
            case A:
                this.deplacerEnAvant(sens);
                break;
            case D:
                this.deplacerADroite(sens);
                break;
            case G:
                this.deplacerAGauche(sens);
                break;
            default:
                break;
        }
    }

    private void deplacerADroite(EDirection sens) {
        switch (sens) {
            case NORTH:
                this.robot.setSens(EAST);
                break;
            case EAST:
                this.robot.setSens(SOUTH);
                break;
            case SOUTH:
                this.robot.setSens(WEST);
                break;
            case WEST:
                this.robot.setSens(NORTH);
                break;
            default:
                break;
        }
    }

    private void deplacerAGauche(EDirection sens) {
        switch (sens) {
            case NORTH:
                this.robot.setSens(WEST);
                break;
            case WEST:
                this.robot.setSens(SOUTH);
                break;
            case SOUTH:
                this.robot.setSens(EAST);
                break;
            case EAST:
                this.robot.setSens(NORTH);
                break;
            default:
                break;
        }
    }

    private void deplacerEnAvant(EDirection sens) throws DeplacementException {
        int x = this.robot.getCaseFinale().x();
        int y = this.robot.getCaseFinale().y();
        switch (sens) {
            case NORTH:
                y = y - 1;
                break;
            case EAST:
                x = x + 1;
                break;
            case WEST:
                x = x - 1;
                break;
            case SOUTH:
                y = y + 1;
                break;
            default:
                break;
        }
        try {
            this.robot.setCaseFinale(this.pelouse.getCase(x, y));
        } catch (Exception e) {
            throw new DeplacementException("Déplacement Impossible !");
        }
    }
}