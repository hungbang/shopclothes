package facade;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import session4.CommonBean;

@Stateless
public class AbstractFacadeBean implements AbstractFacade {

	public CommonBean getCommonBean() {
		
		CommonBean commonBean;
		try {
			Context ctx = new InitialContext();
			commonBean = (CommonBean) ctx.lookup("java:global/shopclothes/CommonBeanImpl");
		} catch (NamingException e) {
			System.out.println("===Bean Not Found=====");
			commonBean = null;
			e.printStackTrace();
		}
		return commonBean;
	}

	
	
}
