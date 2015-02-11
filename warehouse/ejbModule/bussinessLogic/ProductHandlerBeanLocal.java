package bussinessLogic;

import java.util.List;

import javax.ejb.Local;

import entities.Product;
import entities.UnitOfMeasureEnum;

@Local
public interface ProductHandlerBeanLocal {

	public void createProduct(String code, String name, Float weight,
			String description, float unitPrice,
			UnitOfMeasureEnum unitOfMeasure, boolean active, float threshold);

	public List<Product> getAllProducts();

	public Product getProduct(String code);

	public Product getProduct(Long id);

	public void updateProduct(String code, String name, Float weight,
			String description, float unitPrice,
			UnitOfMeasureEnum unitOfMeasure, boolean active, float threshold);

	public void deleteProduct(Product product);

	public void activate(Product product);

	public void deactivate(Product product);
}
