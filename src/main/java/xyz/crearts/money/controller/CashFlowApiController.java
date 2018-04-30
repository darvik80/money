package xyz.crearts.money.controller;

import org.springframework.web.bind.annotation.*;
import xyz.crearts.money.entity.CashFlow;
import xyz.crearts.money.repository.CashFlowRepository;

@RestController
@RequestMapping("/rest/cash_flow")
public class CashFlowApiController {
    private CashFlowRepository cashFlowRepository;

    public CashFlowApiController(CashFlowRepository cashFlowRepository) {
        this.cashFlowRepository = cashFlowRepository;
    }

    @GetMapping({"", "/"})
    public Object flowsAction() {
        return cashFlowRepository.findAllByOrderByIdDesc();
    }


    @PutMapping("/{id}")
    public Object updateAction(@PathVariable long id, @RequestBody CashFlow flow) {
        flow.setId(id);
        return this.cashFlowRepository.save(flow);
    }

    @PostMapping("/")
    public Object createAction(@RequestBody CashFlow flow) {
        return this.cashFlowRepository.save(flow);
    }
}
