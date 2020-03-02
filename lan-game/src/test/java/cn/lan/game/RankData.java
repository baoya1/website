package cn.lan.game;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * 封装rank json数据的实体类
 *
 * @author lan
 * @date 2020/3/1 23:07
 */
@Data
public class RankData {

    BasicData data;
    String msg;
    String status;
}

@Data
class BasicData {

    String type;
    Integer seasonId;
    Integer dateKey;
    Integer status;
    Timestamp updateTime;
    List<Ranks> ranks;
}

@Data
class Ranks {
    Integer rating;
    String battleTag;
    Integer rank;
}
