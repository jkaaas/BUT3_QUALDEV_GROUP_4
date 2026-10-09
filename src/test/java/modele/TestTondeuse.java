package modele;

import enumerations.EDirection;
import exceptions.DeplacementException;
import manager.TondeuseManager;
import org.junit.Assert;
import org.junit.Test;

import static enumerations.EDeplacement.*;
import static enumerations.EDeplacement.D;
import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;

public class TestTondeuse {
    private Tondeuse tondeuse1;
    private Tondeuse tondeuse2;

    @Test
    public void setUp() throws DeplacementException {
        Grille pelouse = new Grille(5, 5);

        this.tondeuse1 = new Tondeuse(5, 5, 1, 2, NORTH);
        TondeuseManager manager1 = new TondeuseManager(tondeuse1, pelouse);
        manager1.deplacement(G);
        manager1.deplacement(A);
        Assert.assertEquals(0, tondeuse1.getCaseFinale().x());
        Assert.assertEquals(2, tondeuse1.getCaseFinale().y());
        manager1.deplacement(G);
        manager1.deplacement(A);
        Assert.assertEquals(0, tondeuse1.getCaseFinale().x());
        Assert.assertEquals(3, tondeuse1.getCaseFinale().y());
        manager1.deplacement(G);
        manager1.deplacement(A);
        Assert.assertEquals(1, tondeuse1.getCaseFinale().x());
        Assert.assertEquals(3, tondeuse1.getCaseFinale().y());
        manager1.deplacement(G);
        manager1.deplacement(A);
        Assert.assertEquals(1, tondeuse1.getCaseFinale().x());
        Assert.assertEquals(2, tondeuse1.getCaseFinale().y());
        manager1.deplacement(A);
        Assert.assertEquals(1, tondeuse1.getCaseFinale().x());
        Assert.assertEquals(1, tondeuse1.getCaseFinale().y());

        this.tondeuse2 = new Tondeuse(5, 5, 3, 3, EAST);
        TondeuseManager manager2 = new TondeuseManager(tondeuse2, pelouse);
        manager2.deplacement(A);
        Assert.assertEquals(4, tondeuse2.getCaseFinale().x());
        Assert.assertEquals(3, tondeuse2.getCaseFinale().y());
        manager2.deplacement(A);
        Assert.assertEquals(5, tondeuse2.getCaseFinale().x());
        Assert.assertEquals(3, tondeuse2.getCaseFinale().y());
        manager2.deplacement(D);
        manager2.deplacement(A);
        Assert.assertEquals(5, tondeuse2.getCaseFinale().x());
        Assert.assertEquals(4, tondeuse2.getCaseFinale().y());
        manager2.deplacement(A);
        Assert.assertEquals(5, tondeuse2.getCaseFinale().x());
        Assert.assertEquals(5, tondeuse2.getCaseFinale().y());
        manager2.deplacement(D);
        manager2.deplacement(A);
        manager2.deplacement(A);
        Assert.assertEquals(3, tondeuse2.getCaseFinale().x());
        Assert.assertEquals(5, tondeuse2.getCaseFinale().y());
        manager2.deplacement(D);
        manager2.deplacement(D);
        manager2.deplacement(A);
        Assert.assertEquals(4, tondeuse2.getCaseFinale().x());
        Assert.assertEquals(5, tondeuse2.getCaseFinale().y());
        Assert.assertEquals(EAST, tondeuse2.getSens());
    }
}