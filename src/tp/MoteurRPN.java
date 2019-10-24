package tp;
import java.util.Stack;

import exception.divisionparzero;
import exception.intervalle;


public class MoteurRPN {

	Stack<Double> p = new Stack<Double> ();
	private final static int min_value=-999;
	private final static int max_value=999;
	

	public MoteurRPN() 
	{
		p=new Stack<>();
	}
	
	public void enregistrer(Double value)throws intervalle {
		if (value> max_value || value< min_value)
		throw new intervalle();
		else
		p.push(value);
	}
	
	public void calcul(operation op) throws divisionparzero{	
		double resultat = 0;
			Double v = depile();
			Double y = depile();
			resultat = op.evaluation(v, y);
			p.push(resultat);
	}
	
	public boolean isEmpty() 
	{
		return p.empty();
		
	}
	
	public double depile() 
	{	
		if (p.isEmpty());
		return p.pop() ;		  
	}
	
	public int nbrOperande()
	{
		return p.size();
		
	}
	
	public Stack<Double> getP() {
		return p;
	}
	
	public String listeOperandes(){
		String string = "";
		for(Double val: p){
			string += val + " ";
		}
		return string;
	}
	
	public boolean operationPossible(){
		if(p.size()>=2) return true;
		else return false;
	}
	
	
}