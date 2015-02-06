package test.server;

import javax.ejb.EJB;

import test.client.GreetingService;
import bussinessLogic.PrivilegeBeanLocal;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@EJB
	bussinessLogic.PrivilegeBeanLocal priv;
	
	public String greetServer(String input) throws IllegalArgumentException {
	
		priv.addPrivilage();
		return "added";
	}

	
}
