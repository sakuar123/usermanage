package com.sakura.usermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Alias("user")
@AllArgsConstructor
@Table(name = "smbms_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "userCode")
    private String userCode;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "userRole")
    private Integer userRole;
    @Column(name = "createdBy")
    private Long createdBy;
    @Column(name = "creationDate")
    private Date creationDate;
}
