package com.dm.mesh.jiraplugin.suprDaily.controller;

import com.dm.mesh.jiraplugin.suprDaily.dto.ResponseDto;
import com.dm.mesh.jiraplugin.suprDaily.dto.viewDto.OrderRequest;
import com.dm.mesh.jiraplugin.suprDaily.service.OrderFulfilmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

@RestController
@RequestMapping("/service")
public class OrderFulfilmentController extends BaseController {

    @Autowired
    private OrderFulfilmentService orderFulfilmentService;

    @PostMapping("/canFulfilOrder")
    public ResponseEntity<ResponseDto<Boolean>> canFulfilOrder(@RequestBody OrderRequest orderRequest) {
        orderFulfilmentService.flattenOrderedItemsList();

        return response("successful.", orderFulfilmentService.canFulfilOrder(orderRequest));
    }

    @PostMapping("/reserOrder")
    public void reserveOrder(@RequestBody OrderRequest orderRequest) {
        orderFulfilmentService.flattenOrderedItemsList();

        orderFulfilmentService.reserveOrder(orderRequest);
    }
}
