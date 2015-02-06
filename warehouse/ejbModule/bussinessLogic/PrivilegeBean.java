package bussinessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Priviliges;

/**
 * Session Bean implementation class PrivilegeBean
 */
@Stateless
public class PrivilegeBean implements PrivilegeBeanLocal {

	@PersistenceContext(unitName = "warehouse")
    private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public PrivilegeBean() {
        // TODO Auto-generated constructor stub
    
    }
    
    @Override
    public void addPrivilage() {
    	// TODO Auto-generated method stub
    	Priviliges privilage  = new Priviliges("1","add");
    	entityManager.persist(privilage);
    	System.out.println("Test");
    }
  

}
