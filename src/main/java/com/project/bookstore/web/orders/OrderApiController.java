package com.project.bookstore.web.orders;

import com.project.bookstore.web.orders.dto.SumDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "주문", description = "주문 관리", tags = { "주문" })
@RequestMapping("/orders")
@CrossOrigin("*")
@RestController
public class OrderApiController {

    @ApiOperation(value = "주문")
    @PostMapping("/orderPay")
    public String orders(@RequestParam("isbn") String isbn, @RequestParam("os") String os) {
        
        return null;
    }

}
