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

    @Query("select new xyz.crearts.money.entity.CashFlowPieChart(cs.category.id, cs.category.name, sum(cs.amount)) from CashFlow cs group by cs.category.id")
    List<CashFlowPieChart> getAllGroupByCategory();
}
