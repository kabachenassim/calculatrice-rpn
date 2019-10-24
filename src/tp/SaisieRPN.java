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
			
			if (scanner.hasNextDouble()) { 
				moteur.enregistrer(scanner.nextDouble()); 
				System.out.println(moteur.listeOperandes());
				string = scanner.nextLine(); 
			}
			
			else { 
				string = scanner.nextLine();
				if (this.testeOperation(string)) 
					if (moteur.operationPossible()) { 
						 
						moteur.calcul(this.renvoieOperation(string)); 
						System.out.println(moteur.listeOperandes());  
					} 
				
					else throw new operationex();  
						
				 
				else if (string.equals("exit")) {
					arret = true;
					System.out.println("CALCULATRICE QUITTEE. ");
				}
				
				else
					System.out.println("ERREUR CALCULATRICE : Saisie Incorrecte. ");
			}
		}
	}
		
	
	private boolean testeOperation(String string) {
		if (string.length() != 1)
			return false;

		return this.renvoieOperation(string) != null;
	}
	
	private operation renvoieOperation(String string) {
		for (operation op : operation.values())
			if (string.charAt(0)  == (op.getsymbole()).charAt(0))
				return op;
		return null;

	}
	
	public MoteurRPN getMoteurRPN() {
		return this.moteur;
	
	}
	
	public void afficheValues(){
		System.out.println(moteur.listeOperandes());
	}	
}
