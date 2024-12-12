package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
	}


	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}

	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
        untel.ajouteEnseignement(uml, 0, 20, 0);

		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

	}

    @Test
    public void testHeuresPrevuPourUE() {
        untel.ajouteEnseignement(uml, 0, 0, 0);
        UE test = new UE("test");

        assertEquals(untel.heuresPrevuesPourUE(test), 0);
    }

    @Test
    public void testHeuresPrevues() {
        untel.ajouteEnseignement(uml, 10, 0, 0);
        UE maths = new UE("maths");
        untel.ajouteEnseignement(maths, 0,  10, 0);

        assertEquals(untel.heuresPrevues(),25);

    }

}
