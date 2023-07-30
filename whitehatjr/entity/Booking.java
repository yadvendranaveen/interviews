package com.dm.mesh.storagelayer.whiteHat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author yadvendranaveen
 * Date: 2021-06-04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    private Integer id;

    private Vehicle vehicle;
    private User user;
    private LocalDate start;
    private LocalDate end;
    private boolean returned;

}
