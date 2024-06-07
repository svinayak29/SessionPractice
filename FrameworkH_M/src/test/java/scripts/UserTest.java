package scripts;

import org.testng.annotations.Test;

import com.utilities.BaseClass;

public class UserTest extends BaseClass {

	@Test
	public void AddProductFromHome() throws InterruptedException {
		
		
		home.action(gUtil, "Divided", "left", 0.75);
		addToCart.proceedToCartDry();
		shoppingBag.validateDryProd(gUtil, "2");
		//Hello
		//Hello
	}
	
}
