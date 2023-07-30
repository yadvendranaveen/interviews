package com.dm.mesh.storagelayer.whiteHat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yadvendranaveen
 * Date: 2021-06-04
 */

@Getter
@AllArgsConstructor
public enum TransactionStatus {
    REQUESTED,
    PROCESSING,
    COMPLETED,
    ON_HOLD
}
