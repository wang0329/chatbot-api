package com.wbj.chatbot.api.domain.zsxq.model.res;

import com.wbj.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @author Java不良人
 * @date 2023/3/10
 */
public class RespData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
