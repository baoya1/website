package com.lan.srt.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_userinfo")
@Entity
@Data
@Accessors(chain = true)
public class UserInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "file_name"
    )
    private String fileName;
    @Column(
            name = "user_addr"
    )
    private String userAddr;
    @Column(
            name = "user_agent"
    )
    private String userAgent;
    @Column(
            name = "operation_time"
    )
    private Date operationTime;
}
