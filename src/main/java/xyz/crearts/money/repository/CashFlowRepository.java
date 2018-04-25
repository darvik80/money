package xyz.crearts.money.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.CashFlow;

public interface CashFlowRepository extends CrudRepository<CashFlow, Long> {
}
