package tp;
import exception.divisionparzero;

public enum operation {
	
	 moins ("-") {
      public double evaluation(double a,double b) {
    	  return b-a;
      }	
		},
	 plus("+"){
	  public double evaluation(double a,double b) {
		  return a+b;
		      }	
		},
	 div("/"){
		public double evaluation(double a,double b)throws divisionparzero {
		   if (b==0) throw new divisionparzero();
		    return a/b;
		      }	
		},
	 multi("*"){
		public double evaluation (double a, double b) {
			return a*b;
		}
		};

	
	
	 String symbole;
	 operation(String symbole) {
		this.symbole=symbole;
	}
	 public abstract double evaluation(double a,double b) throws divisionparzero;
	
	 public String getsymbole() {  
	      return  this.symbole ;  
	 }   
}
