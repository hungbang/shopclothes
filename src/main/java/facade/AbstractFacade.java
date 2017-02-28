package facade;

import javax.ejb.Local;

import session4.CommonBean;

@Local
public interface AbstractFacade {
	public CommonBean getCommonBean();
	
}
