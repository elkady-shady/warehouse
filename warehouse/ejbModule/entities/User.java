package entities;

// Generated Jan 28, 2015 12:24:24 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user")
@NamedQueries({@NamedQuery(name="User.findAll",query="select u from User u"),
@NamedQuery(name="User.login",query="select COUNT(u.id) c from User u where u.userName=:username AND u.password=:password")})
public class User implements java.io.Serializable {

	private Integer id;
	private Role role;
	private String userName;
	private String password;
	private String code;
	private Set<Alarm> alarms = new HashSet<Alarm>(0);
	private Set<Client> clients = new HashSet<Client>(0);

	public User() {
	}

	public User(Role role) {
		this.role = role;
	}

	public User(Role role, String userName, String password, String code,
			Set<Alarm> alarms, Set<Client> clients) {
		this.role = role;
		this.userName = userName;
		this.password = password;
		this.code = code;
		this.alarms = alarms;
		this.clients = clients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "user_name", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "code", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_alarms", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "alarm_id", nullable = false, updatable = false) })
	public Set<Alarm> getAlarms() {
		return this.alarms;
	}

	public void setAlarms(Set<Alarm> alarms) {
		this.alarms = alarms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
