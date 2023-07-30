package com.dm.mesh.storagelayer.whiteHat.entity;

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
public class User {

    private String email;

    // other details like phone, address, etc.
}
