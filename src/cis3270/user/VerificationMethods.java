package cis3270.user;

public class VerificationMethods {
	
	public static void main(String [] args) {
		
		Vars varsObject = new Vars();
		String email = varsObject.getEmail();
		String state = varsObject.getEmail();
		String zip = varsObject.getEmail();
		
		
	}
	
	public boolean email (String email) {
		
		if(email.contains(".com") && email.contains("@")) {
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean state (String state) {
		
		if {
		state.matches("AL | AK | AZ | AR |CA | CO |CT | DE | DC | FL "
				+ "| GA | HI | ID | IL | IN |IA | KS | KY | LA "
				+ "| ME | MD | MA | MI | MN | MS |MO | MT "
				+ "| NE | NV | NH |NJ | NM | NY | NC | ND "
				+ "| OH | OK | OR | PA | RI | SC | SD "
				+ "| TN | TX | UT | VT | VA | WA | WV "
				+ "| WI | WY ");
		}
	            
	   if(state.length() > 2) {
			System.out.println("State is abbreviated");	
		}
	   
	   else {
		   return false;
	   }
	}
	
	public void zipcode(String zip) {
		if(zip.matches("\\d{5}")) {
			System.out.println("Zipcode is valid");
		}
	}
}
