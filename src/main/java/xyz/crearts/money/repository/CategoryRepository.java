package xyz.crearts.money.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
