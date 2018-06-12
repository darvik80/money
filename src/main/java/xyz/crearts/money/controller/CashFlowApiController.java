package xyz.crearts.money.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.entity.CashFlowPieChart;
import xyz.crearts.money.repository.CashFlowRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@RequestMapping("/rest/cash_flow")
public class CashFlowApiController {
    private CashFlowRepository cashFlowRepository;

    public CashFlowApiController(CashFlowRepository cashFlowRepository) {
        this.cashFlowRepository = cashFlowRepository;
    }

    @GetMapping({"", "/"})
    public Page<CashFlow> flowsAction(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        LocalDateTime begin = now.truncatedTo(ChronoUnit.DAYS).minusDays(now.getDayOfWeek().getValue()-1);

        return cashFlowRepository.findAllByCreatedAtAfterOrderByCreatedAtDesc(Timestamp.valueOf(begin), pageable);
    }


    @PutMapping("/{id}")
    public Object updateAction(@PathVariable long id, @RequestBody CashFlow flow) {
        flow.setId(id);
        return this.cashFlowRepository.save(flow);
    }

    @GetMapping("/report/pie/{period}")
    public List<CashFlowPieChart> pieReportAction(@PathVariable(value = "period", required = false) String period) {
        LocalDateTime begin, end;
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        switch (period) {
            case "day":
                begin = now;
                end = begin.plus(1, ChronoUnit.DAYS);
                break;
            case "week":
                begin = now.minusDays(now.getDayOfWeek().getValue()-1);
                end = begin.plus(1, ChronoUnit.WEEKS);
                break;
            case "month":
            default:
                begin = now.minusDays(now.getDayOfMonth()-1);
                end = begin.plus(1, ChronoUnit.MONTHS);
                break;
        }

        return this.cashFlowRepository.getAllGroupByCategory(Timestamp.valueOf(begin), Timestamp.valueOf(end));
    }

    @Data
    @Builder
    static class ErrorInfo {
        private String field;
        private String description;
    }


    @PostMapping("/")
    public Object createAction(@Valid @RequestBody CashFlow flow, BindingResult bindingResult, HttpServletResponse response) {
        if(bindingResult.hasErrors()){

            List<ErrorInfo> errors = new ArrayList<>();
            bindingResult.getAllErrors().forEach(err -> {
                if (err instanceof FieldError) {
                    errors.add(ErrorInfo.builder()
                            .field(((FieldError)err).getField())
                            .description(err.getDefaultMessage())
                            .build());
                }
            });

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return errors;
        }

        return this.cashFlowRepository.save(flow);
    }

    @DeleteMapping("/{id}")
    public String deleteAction(@PathVariable long id) {
        this.cashFlowRepository.deleteById(id);
        return "success";
    }
}
