package xyz.crearts.money.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.entity.CashFlowPieChart;

import java.util.List;

public interface CashFlowRepository extends CrudRepository<CashFlow, Long> {
    Page<CashFlow> findAllByOrderByIdDesc(Pageable pageable);

    @Query(value = "SELECT `category_id`, `name`,  SUM(`amount`) from `cash_flow` JOIN `category` ON `category_id` = `category`.`id` GROUP BY `category_id`", nativeQuery = true)
    List<?> getAllGroupByCategory();
}
