package com.stream.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Stream on 2018/7/4.
 */

@Setter
@Getter
@ToString
public class UserEntity {

    private Long id;

    private String name;

    private char[] password;

    private Integer age;

    private String sex;
}
