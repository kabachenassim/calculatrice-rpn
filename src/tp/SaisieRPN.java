package tp;
import java.util.Scanner;
import java.util.Stack;

import exception.divisionparzero;
import exception.intervalle;
import exception.operationex;
import exception.saisieex;


public class SaisieRPN {

private Scanner scanner;
	
	private MoteurRPN moteur;
		
	public SaisieRPN() {
		this.scanner = new Scanner(System.in);
		this.moteur = new MoteurRPN();
	}
	
	
	public void saisie() throws operationex,intervalle,divisionparzero{
		String string = "";
		boolean arret = false;
		System.out.println("introduire un nombre, op�ration.");
		while (arret == false) {
			
			if (scanner.hasNextDouble()) { // si la saisie est un nombre
				moteur.enregistreOperande(scanner.nextDouble()); // on met le nombre en haut de la pile
				System.out.println(moteur.listeOperandes()); // affichage op�rande
				string = scanner.nextLine(); // lecture de la prochaine saisie
			}
			
			else { // si la saisie est une op�ration ou une chaine de caract�re
				string = scanner.nextLine();
				if (this.testeOperation(string)) // si la saisie est une op�ration
					if (moteur.operationPossible()) { // si la pile a au moins deux �l�ments
						// enl�ve les deux premiers �l�ments, fait l'op�ration et met le r�sultat dans la pile 
						moteur.calculeOperation(this.renvoieOperation(string)); 
						System.out.println(moteur.listeOperandes());  
					} 
				
					else throw new operationex(); // sinon si la pile n'a pas au moins deux �l�ments 
						
				// si la saisie est "exit", on arr�te le programme 
				else if (string.equals("exit")) {
					arret = true;
					System.out.println("CALCULATRICE QUITTEE. ");
				}
				
				else
					System.out.println("ERREUR CALCULATRICE : Saisie Incorrecte. ");
			}
		}
	}
		
	/**
	 * M�thode priv�e interne � la classe qui permet de savoir si une chaine de caract�re correspond � 
	 * PLUS, MOINS, MULT, DIV
	 * @param string
	 * @return vrai ou faux
	 */
	private boolean testeOperation(String string) {
		if (string.length() != 1)
			return false;

		return this.renvoieOperation(string) != null;
	}
	
	/**
	 * M�thode priv�e interne � la classe, qui renvoie l'op�ration
	 * @param string
	 * @return vrai ou faux
	 */
	private operation renvoieOperation(String string) {
		for (operation op : operation.values())
			if (string.charAt(0)  == (op.getsymbole()).charAt(0))
				return op;
		return null;

	}
	/**
	 * Acesseur de l'attribut moteur
	 * @return l'attribut moteur
	 */
	public MoteurRPN getMoteurRPN() {
		return this.moteur;
	
	}
	
	/**
	 * M�thode qui permet d'afficher les op�randes qui sont stock�s dans la pile
	 */
	public void afficheValues(){
		System.out.println(moteur.listeOperandes());
	}	
}
