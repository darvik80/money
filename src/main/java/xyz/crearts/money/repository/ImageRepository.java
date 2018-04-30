package xyz.crearts.money.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
