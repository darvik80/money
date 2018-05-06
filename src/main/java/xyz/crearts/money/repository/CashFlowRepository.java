package xyz.crearts.money.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.CashFlow;

import java.util.List;

public interface CashFlowRepository extends CrudRepository<CashFlow, Long> {
    List<CashFlow> findAllByOrderByIdDesc();
}
