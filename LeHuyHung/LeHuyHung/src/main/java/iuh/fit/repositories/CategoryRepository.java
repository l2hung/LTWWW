package iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.fit.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
