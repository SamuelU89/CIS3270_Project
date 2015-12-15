package cis3270.user;

public class VerificationMethods {
	
	public static void main(String [] args) {
		
		Vars varsObject = new Vars();
		String email = varsObject.getEmail();
		String state = varsObject.getEmail();
		int zip = varsObject.getEmail();
		
		
	}
	
	public boolean email (String email) {
		
		if(email.contains(".com") && email.contains("@")) {
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void state (String state) {
		CharSequence[] stateab = new CharSequence ['ZZ', 'AL','AK','AZ','AR','CA','CO','CT','DE','DC','FL','GA','HI','ID','IL','IN',
	            'IA','KS','KY','LA','ME','MD','MA','MI','MN', 'MS', 'MO','MT','NE','NV','NH',
	            'NJ','NM','NY','NC','ND','OH','OK','OR','PA','RI','SC','SD','TN','TX','UT',
	            'VT','VA','WA','WV','WI','WY'];
		
	   if(state.length() > 2) {
			System.out.println("State is abbreviated");
		}
		
	   for(int i = 1; i < stateab.length; i++) {
		   if ( state = stateab[i]) {
			   System.out.println("State is one of the 50");
		   }
		   
		   else
			   System.out.println("State is not one of the 50");
	   }
	}
}
