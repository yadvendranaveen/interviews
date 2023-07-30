package com.dm.mesh.storagelayer.whiteHat.entity;

import com.dm.mesh.storagelayer.whiteHat.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yadvendranaveen
 * Date: 2021-06-04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    private Integer id;
    //    private Blob qr/barcode;
//    private String vehicleNumber;
    private VehicleType vehicleType;
    private boolean available = true;
    private Integer parkingSpot; // 1:1
}
