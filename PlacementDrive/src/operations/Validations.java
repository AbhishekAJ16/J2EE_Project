package operations;

import java.sql.Date;

public class Validations {
	public static boolean isEmpty(String value) {
		if (value != null) {
			return value.trim().isEmpty();
		}
		return false;
	}

	public static boolean isNumber(String value) {
		try {
			if (value != null) {
				Integer.parseInt(value.trim());
				return true;
			}

		} catch (NumberFormatException ex) {
		}
		return false;
	}

	public static boolean validContactNo(String value) {
    if(value!=null && value.length() == 10){
    	for(int i=0;i<value.length();i++){
    		if(!Character.isDigit(value.charAt(i))){
    			return false;
    		}
    	}
    	return true;
    }
		return false;

	}
	public static boolean validDate(String value){
		try{
		Date.valueOf(value);
		return true;
		}catch(Exception ex){}
	return false;
	}
	public static boolean onlyCharacter(String value){
		if(value!=null){
			return value.matches("^([a-zA-z.'\\s]{2,50})$");
		}return false;
		
	}
}
