package cis3270.user;

public class VerificationMethods {

	/**
	 * 
	 * 
	 * These methods will be used later to validate inputs
	 * 
	 */
	
	public boolean email (String email) {
		
		if(email.matches("..com") && email.matches(".@")) {
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean state (String state) {
		
		if (state.matches("AL | AK | AZ | AR |CA | CO |CT | DE | DC | FL "
				+ "| GA | HI | ID | IL | IN |IA | KS | KY | LA "
				+ "| ME | MD | MA | MI | MN | MS |MO | MT "
				+ "| NE | NV | NH |NJ | NM | NY | NC | ND "
				+ "| OH | OK | OR | PA | RI | SC | SD "
				+ "| TN | TX | UT | VT | VA | WA | WV "
				+ "| WI | WY ") && state.length() > 2 ) {
			return true;
		}
		
		else 
			return false;
			
		}     
	
	public void zipcode(String zip) {
		if(zip.matches("\\d{5}")) {
			System.out.println("Zipcode is valid");
		}


	}
}