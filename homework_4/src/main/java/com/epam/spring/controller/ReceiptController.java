package com.epam.spring.controller;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public List<ReceiptDto> getReceipts(@PathVariable String email) {
        return receiptService.getReceipts(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ReceiptDto createReceipt(@RequestBody @Validated(OnCreate.class) ReceiptDto receiptDto) {
        return receiptService.makeOrder(receiptDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/cancel")
    public void cancelReceipt(@PathVariable int id) {
        receiptService.cancelReceipt(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/pay")
    public void payReceipt(@PathVariable int id) {
        receiptService.payReceipt(id);
    }

}
