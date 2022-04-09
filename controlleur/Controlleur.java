package controlleur;

import javax.swing.JFrame;
//interface permettant d'acceder à calendrierControlleur avec un controlleur AccueuilControlleur (pour employe)
//ou avec un controlleur CantineParentControlleur (pour parent)

//la seule methode necessaire en commun est end
public interface Controlleur {
	public void end ();//la sous fenetre est ferme, on remet la fenetre du controlleur actuel
}
