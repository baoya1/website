package cn.lan.game;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 从炉石官网排行榜获取战棋前200名信息
 * @author lan
 * @date 2020/3/1 22:33
 */
public class HsRanking {

    @Test
    public void test() {


        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost();
            URI uri = new URI("https://hs.blizzard.cn/action/hs/leaderboards/season/rank");
            httpPost.setURI(uri);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // String entity="seasonId=0&type=BG&t=1580570348000";
            String entity = "seasonId=0&type=BG";
            HttpEntity httpEntity = new StringEntity(entity);
            httpPost.setEntity(httpEntity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine() != null) {

                HttpEntity resEntity = response.getEntity();
                String result = EntityUtils.toString(resEntity, StandardCharsets.UTF_8);
                RankData rankData = JSONObject.parseObject(result, RankData.class);
                List<Ranks> ranks = rankData.getData().getRanks();
                for (Ranks rank : ranks) {
                    System.out.printf("%-8s| %-10s| %-20s%n", "排名: " + rank.getRank(), "分数: " + rank.getRating(), "ID: " + rank.getBattleTag());
                    //System.out.println("排名: "+ rank.getRank()+"| ID: "+ rank.getBattleTag()+" | 分数: "+rank.getRating());
                    if (("虎牙麦抖丶宝牙").equals(rank.getBattleTag())) {
                        System.out.println("------我的排名: " + rank.getRank() + "| ID: " + rank.getBattleTag() + " | 分数: " + rank.getRating());
                    }
                }
                //System.out.println(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
