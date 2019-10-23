package tp;
import java.util.Stack;

import exception.divisionparzero;
import exception.intervalle;


public class MoteurRPN {

	private Stack<Double> pile;
	
	private static final double MIN_VALUE = -1000;
	private static final double MAX_VALUE =  1000;
	
	
	public MoteurRPN() {
		pile = new Stack<Double>();
	}
	
	public Double enregistreOperande(double val)throws intervalle{
		if(Math.abs(val)>MAX_VALUE) throw new intervalle();
		if(Math.abs(val)<MIN_VALUE) throw new intervalle();
		return pile.push(val);
	}
		
	public Double calculeOperation(operation op)throws divisionparzero,intervalle{
		return enregistreOperande(op.evaluation(pile.pop(), pile.pop()));
	}

	public boolean operationPossible(){
		if(pile.size()>=2) return true;
		else return false;
	}

	public String specifieMinMaxValue(){
		return "MIN_VALUE = " + MIN_VALUE + " et MAX_VALUE = " + MAX_VALUE + ".";
	}

	public String listeOperandes(){
		String string = "";
		for(Double val: pile){
			string += val + " ";
		}
		return string;
	}
	
	public Stack<Double> getPile(){
		return this.pile;
	}}
