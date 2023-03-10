package com.wbj.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @author Java不良人
 * @date 2023/3/10
 */
public interface IOpenAI {
    String doChatGPT(String question) throws IOException;
}
