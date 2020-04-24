package com.sakura.usermanage.common.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonsCodeEnum {
    success(200, "succes"),
    fail(999, "fail");
    private Integer code;
    private String name;
}
