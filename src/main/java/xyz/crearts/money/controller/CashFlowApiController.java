package xyz.crearts.money.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<CashFlow> flowsAction(Pageable pageable) {
        return cashFlowRepository.findAllByOrderByIdDesc(pageable);
    }


    @PutMapping("/{id}")
    public Object updateAction(@PathVariable long id, @RequestBody CashFlow flow) {
        flow.setId(id);
        return this.cashFlowRepository.save(flow);
    }


    @GetMapping("/report/pie")
    public Object pieReportAction() {
        return this.cashFlowRepository.getAllGroupByCategory();
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
