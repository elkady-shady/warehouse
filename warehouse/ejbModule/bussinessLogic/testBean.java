package bussinessLogic;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class testBean {
	
	@EJB
	PrivilegeBeanLocal priv;
	
	@PostConstruct
	public void testBeans(){
		System.out.println("before");
		priv.addPrivilage();
		System.out.println("after");
	}

}
