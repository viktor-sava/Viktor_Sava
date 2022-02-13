package com.epam.spring.controller;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
@RequiredArgsConstructor
@Slf4j
public class ReceiptController {

    private final ReceiptService receiptService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public List<ReceiptDto> getReceiptsByUserEmail(@PathVariable String email) {
        log.info("getReceipts by user email {}", email);
        return receiptService.getReceipts(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReceiptDto createReceipt(@RequestBody @Validated(OnCreate.class) ReceiptDto receiptDto) {
            log.info("makeOrder with customer email {}", receiptDto.getEmail());
        return receiptService.makeOrder(receiptDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}/cancel")
    public void cancelReceiptById(@PathVariable int id) {
        log.info("cancel receipt by id {}", id);
        receiptService.cancelReceipt(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}/pay")
    public void payReceiptById(@PathVariable int id) {
        log.info("pay receipt by id {}", id);
        receiptService.payReceipt(id);
    }

}
