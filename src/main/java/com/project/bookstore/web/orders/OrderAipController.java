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
@RequiredArgsConstructor
@RestController
public class OrderAipController {

    @ApiOperation(value = "주문")
    @PostMapping("/{isbn}")
    public RedirectView orders(@PathVariable("isbn") String isbn, @RequestBody SumDto sumDto) {
        System.out.println("들어왔는가");
        return new RedirectView("/orders/" + isbn);
    }

}
