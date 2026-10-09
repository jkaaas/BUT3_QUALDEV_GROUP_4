package modele;

import enumerations.EDirection;
import interfaces.IRobot;

/***
 * Une tondeuse connaît sa position et son sens.
 * Les déplacements sont gérés par TondeuseManager.
 * @author stephane.joyeux
 *
 */
public class Tondeuse implements IRobot {

	// Une tondeuse se déplace sur une pelouse.
	private Grille pelouse;

	// Départ de la tondeuse :
	private Case caseDepart;

	// Arrivée :
	private Case caseFinale;

	// Sens de la tondeuse :
	private EDirection sens;

	public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
		this.pelouse = new Grille(lignes, colonnes);
		this.caseDepart = this.pelouse.getCase(posX, posY);
		this.caseFinale = this.pelouse.getCase(posX, posY);
		this.sens = sens;
	}

	public Case getCaseDepart() {
		return caseDepart;
	}

	@Override
	public Case getCaseFinale() {
		return caseFinale;
	}

	@Override
	public void setCaseFinale(Case caseFinale) {
		this.caseFinale = caseFinale;
	}

	@Override
	public EDirection getSens() {
		return sens;
	}

	@Override
	public void setSens(EDirection sens) {
		this.sens = sens;
	}

	@Override
	public Grille getGrille() {
		return pelouse;
	}

	@Override
	public String toString() {
		return "Ma position finale est X = " + this.getCaseFinale().x() + ", Y = " + this.getCaseFinale().y()
				+ " et je suis orientée : " + this.sens;
	}
}