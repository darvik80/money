package xyz.crearts.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import xyz.crearts.money.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
