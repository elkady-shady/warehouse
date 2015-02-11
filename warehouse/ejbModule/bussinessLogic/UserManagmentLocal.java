package bussinessLogic;

import java.util.List;

import javax.ejb.Local;

import entities.Priviliges;
import entities.Role;
import entities.User;

@Local
public interface UserManagmentLocal {

/*
 * CRUD User Functions
 */
boolean addUser(User user);
boolean deleteUser(User user);
boolean updateUser(User user);
List<User> getUsers();
/*
 * CRUD Privileges Functions
 */
boolean addPrivilege(Priviliges priv);
boolean deletePrivilege(Priviliges priv);
boolean updatePrivilege(Priviliges priv);
List<Priviliges> getPrivileges();
/*
 * CRUD Role Functions
 */
boolean addRole(Role role);
boolean updateRole(Role role);
boolean deleteRole(Role role);
List<Role> geteRoles();

/*
 * Login/Logout Functions
 */

int Login(String username,String password);
void logout();
}
