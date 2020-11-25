package com.project.bookstore.web.orders;

import com.project.bookstore.web.orders.dto.SumDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "주문", description = "주문 관리", tags = { "주문" })
@RequestMapping("/orders")
@CrossOrigin("*")
@RestController
public class OrderApiController {

    @ApiOperation(value = "주문")
    @PostMapping("/{isbn}")
    public String orders(@PathVariable("isbn") String isbn, @RequestBody SumDto sumDto) {
        System.out.println(sumDto.getOrderSum());
        sumDto.setOrderSum(sumDto.getOrderSum());
        return null;
    }

}
