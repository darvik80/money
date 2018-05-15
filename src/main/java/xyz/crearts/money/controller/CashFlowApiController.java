package xyz.crearts.money.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.repository.CashFlowRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

@RestController
@RequestMapping("/rest/cash_flow")
public class CashFlowApiController {
    private CashFlowRepository cashFlowRepository;

    public CashFlowApiController(CashFlowRepository cashFlowRepository) {
        this.cashFlowRepository = cashFlowRepository;
    }

    @GetMapping({"", "/"})
    public Page<CashFlow> flowsAction(Pageable pageable) {
        return cashFlowRepository.findAllByOrderByIdDesc(pageable);
    }


    @PutMapping("/{id}")
    public Object updateAction(@PathVariable long id, @RequestBody CashFlow flow) {
        flow.setId(id);
        return this.cashFlowRepository.save(flow);
    }


    @GetMapping("/report/pie/{period}")
    public Object pieReportAction(@PathVariable(value = "period", required = false) String period) {
        LocalDateTime begin, end;
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        switch (period) {
            case "day":
                begin = now;
                end = begin.plus(1, ChronoUnit.DAYS);
                break;
            case "week":
                begin = now.minusDays(now.getDayOfWeek().getValue());
                end = begin.plus(1, ChronoUnit.WEEKS);
                break;
            case "month":
            default:
                begin = now.minusDays(now.getDayOfWeek().getValue());
                end = begin.plus(1, ChronoUnit.MONTHS);
                break;
        }

        System.out.println(begin.toString());
        System.out.println(end.toString());

        return this.cashFlowRepository.getAllGroupByCategory(Timestamp.valueOf(begin), Timestamp.valueOf(end));
    }

    @PostMapping("/")
    public Object createAction(@RequestBody CashFlow flow) {
        return this.cashFlowRepository.save(flow);
    }
    @DeleteMapping("/{id}")
    public String deleteAction(@PathVariable long id) {
        this.cashFlowRepository.deleteById(id);
        return "success";
    }
}
