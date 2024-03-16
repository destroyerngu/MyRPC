package com.swu.myRPCVersion2.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 姚依琳-Ezra·lin
 * @version 1.0
 * @create 2024/3/16 14:43
 * @since 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    private Integer id;
    private Integer useId;
    private String title;
}
