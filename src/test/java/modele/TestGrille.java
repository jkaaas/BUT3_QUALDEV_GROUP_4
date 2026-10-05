package modele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGrille {
    private Grille grille;

    @Before
    public void setUp() {
        this.grille = new Grille(5, 5);
    }

    @Test
    public void testVerifierBordureCases() {
        System.out.println("testVerifierBordureCases");
        Assert.assertEquals(36, grille.getTaille());
    };
}