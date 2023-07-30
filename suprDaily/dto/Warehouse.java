package com.dm.mesh.jiraplugin.suprDaily.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author yadvendranaveen
 * Date: 2021-01-22
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private Integer id;

    private Map<DateItemKey, Integer> availableItemMap;

}
