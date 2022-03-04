package com.muskmelon.data.refill.center.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author muskmelon
 * @since 1.0
 */
@Data
public class Credit {

    private Long id;
    private Long userAccountId;
    private Long point;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;


}
