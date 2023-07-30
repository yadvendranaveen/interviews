package com.dm.mesh.jiraplugin.suprDaily.dto.viewDto;

import com.dm.mesh.jiraplugin.suprDaily.dto.Customer;
import com.dm.mesh.jiraplugin.suprDaily.dto.Warehouse;
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
public class OrderRequest {
    private Customer customer;
    private Warehouse warehouse;

    //    TODO: will use for LocalDate
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private String Date;

    private List<ItemRequest> itemRequestList;
}
