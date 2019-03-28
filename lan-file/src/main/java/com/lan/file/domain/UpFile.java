package com.lan.file.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lan
 * @date 2019-03-04 01:41
 */

@Data
@Accessors(chain = true)
@Entity
@Table(name = "tb_file")
public class UpFile implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;
    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String filePath;
    /**
     * 访问路径
     */
    @Column(name = "file_url")
    private String fileUrl;
    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private Long fileSize;
    /**
     * 文件状态：0--不可见，1--可见
     */
    @Column(name = "file_state")
    private String fileState;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;


}
