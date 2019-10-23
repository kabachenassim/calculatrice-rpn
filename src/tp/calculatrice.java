package tp;
import exception.divisionparzero;
import exception.intervalle;
import exception.operationex;
import exception.saisieex;

public enum calculatrice {
	calcul;
	calculatrice() 
	{
	
		SaisieRPN b=new SaisieRPN();
		  
			try {
				b.saisie();
			} catch (intervalle e) {
				
			} catch (operationex e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (divisionparzero e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
			
	
	public static void main(String[] args) {
		calculatrice e;	
	}
}
