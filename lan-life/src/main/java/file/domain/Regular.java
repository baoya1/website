package file.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Lan
 * @date 2019/4/10 21:08
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "tb_regular")
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Regular implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 记录日期
     */
    @Column(name = "record_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date recordDate;

    /**
     * 睡眠时间
     */
    @Column(name = "sleep_time")
    @DateTimeFormat(pattern = "HH-mm")
    private Date sleepTime;

    /**
     * 起床时间
     */
    @Column(name = "up_time")
    @DateTimeFormat(pattern = "HH-mm")
    private Date upTime;

    /**
     * 是否锻炼
     */
    @Column(name = "is_workout")
    private String workout;

    /**
     * 是否学习
     */
    @Column(name = "is_learn")
    private String learn;

    /**
     * 备注信息
     */
    @Column(name = "comment")
    private String comment;


}
