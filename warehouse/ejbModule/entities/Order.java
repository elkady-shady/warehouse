package entities;

// Generated Jan 28, 2015 12:24:24 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "order")
public class Order implements java.io.Serializable {

	private Integer id;
	private Client client;
	private String code;
	private String state;
	private Date deliveryDate;
	private Set<ProductLine> productLines = new HashSet<ProductLine>(0);

	public Order() {
	}

	public Order(Client client) {
		this.client = client;
	}

	public Order(Client client, String code, String state, Date deliveryDate,
			Set<ProductLine> productLines) {
		this.client = client;
		this.code = code;
		this.state = state;
		this.deliveryDate = deliveryDate;
		this.productLines = productLines;
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
	@JoinColumn(name = "client_id", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "code", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "state", length = 45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_date", length = 10)
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public Set<ProductLine> getProductLines() {
		return this.productLines;
	}

	public void setProductLines(Set<ProductLine> productLines) {
		this.productLines = productLines;
	}

}
