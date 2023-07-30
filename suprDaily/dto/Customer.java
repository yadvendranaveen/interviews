package com.dm.mesh.jiraplugin.suprDaily.dto;

import com.dm.mesh.jiraplugin.suprDaily.dto.viewDto.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer id;
    private List<OrderRequest> orderRequestList;
}
