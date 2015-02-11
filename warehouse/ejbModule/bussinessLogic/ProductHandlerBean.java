package bussinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Product;
import entities.UnitOfMeasureEnum;

@Stateless
public class ProductHandlerBean implements ProductHandlerBeanLocal {

	@PersistenceContext(unitName = "warehouse")
	private EntityManager entityManager;

	@Override
	public void createProduct(String code, String name, Float weight,
			String description, float unitPrice,
			UnitOfMeasureEnum unitOfMeasure, boolean active, float threshold) {
		try {
			Product product = new Product(name, code, weight, description,
					unitPrice, unitOfMeasure, active, threshold);
			entityManager.persist(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			List resultList = entityManager.createQuery("From Product")
					.getResultList();
			return resultList;
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

	@Override
	public Product getProduct(String code) {
		try {
			Product product = (Product) entityManager
					.createQuery("select product from product where code=:_code")
					.setParameter("_code", code).getSingleResult();
			return product;
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

	@Override
	public Product getProduct(Long id) {
		try {
			Product product = entityManager.find(Product.class, id);
			return product;
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

	@Override
	public void updateProduct(String code, String name, Float weight,
			String description, float unitPrice,
			UnitOfMeasureEnum unitOfMeasure, boolean active, float threshold) {
		try {
			Product product = getProduct(code);
			product.setName(name);
			product.setWeight(weight);
			product.setDescription(description);
			product.setUnitPrice(unitPrice);
			product.setUnitOfMeasure(unitOfMeasure);
			product.setActive(active);
			product.setThreshold(threshold);

			entityManager.persist(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}

	}

	@Override
	public void deleteProduct(Product product) {
		try {
			entityManager.remove(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

	@Override
	public void activate(Product product) {
		try {
			product.setActive(true);
			entityManager.persist(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

	@Override
	public void deactivate(Product product) {
		try {
			product.setActive(false);
			entityManager.persist(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Show log msg
			throw ex;
		}
	}

}
