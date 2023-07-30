package com.dm.mesh.storagelayer.whiteHat.entity;

import com.dm.mesh.storagelayer.whiteHat.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yadvendranaveen
 * Date: 2021-06-04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ledger {

    private Booking booking;
    private Double amount;
    private TransactionStatus transactionStatus;
}
