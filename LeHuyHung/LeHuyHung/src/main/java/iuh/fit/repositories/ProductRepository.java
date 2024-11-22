package iuh.fit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.fit.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT p FROM Product p WHERE (:cate IS NULL OR p.category.id = :cate) "
            + "AND (:active IS NULL OR p.isActive = :active)")
	List<Product> filterProducts(@Param("cate") Integer cate,
                             @Param("active") Boolean active);


}
