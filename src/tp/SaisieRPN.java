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
		System.out.println("introduire un nombre, opération.");
		while (arret == false) {
			
			if (scanner.hasNextDouble()) { // si la saisie est un nombre
				moteur.enregistreOperande(scanner.nextDouble()); // on met le nombre en haut de la pile
				System.out.println(moteur.listeOperandes()); // affichage opérande
				string = scanner.nextLine(); // lecture de la prochaine saisie
			}
			
			else { // si la saisie est une opération ou une chaine de caractère
				string = scanner.nextLine();
				if (this.testeOperation(string)) // si la saisie est une opération
					if (moteur.operationPossible()) { // si la pile a au moins deux éléments
						// enlève les deux premiers éléments, fait l'opération et met le résultat dans la pile 
						moteur.calculeOperation(this.renvoieOperation(string)); 
						System.out.println(moteur.listeOperandes());  
					} 
				
					else throw new operationex(); // sinon si la pile n'a pas au moins deux éléments 
						
				// si la saisie est "exit", on arrête le programme 
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
	 * Méthode privée interne à la classe qui permet de savoir si une chaine de caractère correspond à 
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
	 * Méthode privée interne à la classe, qui renvoie l'opération
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
	 * Méthode qui permet d'afficher les opérandes qui sont stockés dans la pile
	 */
	public void afficheValues(){
		System.out.println(moteur.listeOperandes());
	}	
}
