package com.wbj.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;


/**
 * @author Java不良人
 * @date 2023/3/10
 */
public class ApiTest {
    @Test
    public void query_unanswered_solution() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/15552554141242/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"1864a701055945-0b6e6815e9aa748-74525476-2073600-1864a701056c75\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2NGE3MDEwNTU5NDUtMGI2ZTY4MTVlOWFhNzQ4LTc0NTI1NDc2LTIwNzM2MDAtMTg2NGE3MDEwNTZjNzUifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"1864a701055945-0b6e6815e9aa748-74525476-2073600-1864a701056c75\"}; zsxq_access_token=D804B702-1BB5-D951-2078-A1281EDB17A1_0D056D04E06DEF57; abtest_env=product; zsxqsessionid=bbb36cb3d7dfd07c0a3af3e33a3ffc8e");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412815185115888/answer");

        post.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"1864a701055945-0b6e6815e9aa748-74525476-2073600-1864a701056c75\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2NGE3MDEwNTU5NDUtMGI2ZTY4MTVlOWFhNzQ4LTc0NTI1NDc2LTIwNzM2MDAtMTg2NGE3MDEwNTZjNzUifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"1864a701055945-0b6e6815e9aa748-74525476-2073600-1864a701056c75\"}; zsxq_access_token=D804B702-1BB5-D951-2078-A1281EDB17A1_0D056D04E06DEF57; abtest_env=product; zsxqsessionid=bbb36cb3d7dfd07c0a3af3e33a3ffc8e");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我还好\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
