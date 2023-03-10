package com.wbj.chatbot.api.domain.zsxq.model.aggregates;

import com.wbj.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * @author Java不良人
 * @date 2023/3/10
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
