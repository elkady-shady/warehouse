package bussinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Priviliges;
import entities.Role;
import entities.User;

/**
 * Session Bean implementation class UserManagment
 */
@Stateless
public class UserManagment implements UserManagmentLocal {

	@PersistenceContext(unitName = "warehouse")
    private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public UserManagment() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addUser(User user) {
		entityManager.persist(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		entityManager.remove(user);
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		return false;
	}

	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		entityManager.persist(role);
		return false;
	}

	@Override
	public boolean updateRole(Role role) {
		// TODO Auto-generated method stub
		entityManager.persist(role);
		return false;
	}

	@Override
	public boolean deleteRole(Role role) {
		// TODO Auto-generated method stub
		entityManager.remove(role);
		return false;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("User.findAll").getResultList();
		
	}

	@Override
	public boolean addPrivilege(Priviliges priv) {
		// TODO Auto-generated method stub
		entityManager.persist(priv);
		return false;
	}

	@Override
	public boolean deletePrivilege(Priviliges priv) {
		// TODO Auto-generated method stub
		entityManager.remove(priv);
		return false;
	}

	@Override
	public boolean updatePrivilege(Priviliges priv) {
		// TODO Auto-generated method stub
		entityManager.persist(priv);
		return false;
	}

	@Override
	public List<Priviliges> getPrivileges() {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Privilage.findAll").getResultList();
	}

	@Override
	public List<Role> geteRoles() {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Role.findAll").getResultList();
	}

	@Override
	public int Login(String username, String password) {
	
		//if returned value equal 1 then user authenticated 
		return (int)entityManager.createNamedQuery("User.login").setParameter("username", username).setParameter("password",password).getSingleResult();
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
