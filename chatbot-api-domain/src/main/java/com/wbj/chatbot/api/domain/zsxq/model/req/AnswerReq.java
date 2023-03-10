package com.wbj.chatbot.api.domain.zsxq.model.req;

/**
 * @author Java不良人
 * @date 2023/3/10
 */
public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
