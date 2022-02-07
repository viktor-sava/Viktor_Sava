package com.epam.spring.controller;

import com.epam.spring.controller.dto.ReceiptDto;
import com.epam.spring.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @PostMapping
    public ReceiptDto createReceipt(@RequestBody ReceiptDto receiptDto) {
        return receiptService.makeOrder(receiptDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}/cancel")
    public void updateProduct(@PathVariable int id) {
        receiptService.cancelReceipt(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}/pay")
    public void deleteProduct(@PathVariable int id) {
        receiptService.payReceipt(id);
    }

}
