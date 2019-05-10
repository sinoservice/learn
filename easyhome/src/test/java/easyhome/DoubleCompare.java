package easyhome;

import org.junit.Test;

public class DoubleCompare {

	@Test
	public void compare(){
		String a = "2.24";
		String b = "3.230";
		Double aa = Double.parseDouble(a);
		Double bb = Double.parseDouble(b);
		if(aa>bb){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
	}
}
