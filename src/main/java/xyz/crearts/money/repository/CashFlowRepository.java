package xyz.crearts.money.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.entity.CashFlowWithCategory;
import xyz.crearts.money.entity.Category;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

public interface CashFlowRepository extends CrudRepository<CashFlow, Long> {
    List<CashFlow> findAllByOrderByIdDesc();
}
