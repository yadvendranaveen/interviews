package com.dm.mesh.jiraplugin.suprDaily.dto.viewDto;

import com.dm.mesh.jiraplugin.suprDaily.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
    private Item item;
    private Integer quantity;
}
