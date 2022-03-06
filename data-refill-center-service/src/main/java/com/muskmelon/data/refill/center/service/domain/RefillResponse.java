package com.muskmelon.data.refill.center.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefillResponse {

    private Integer result;

    private String msg;
}
