package xyz.crearts.money.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.entity.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
