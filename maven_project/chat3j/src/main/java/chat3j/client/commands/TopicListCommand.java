package chat3j.client.commands;

import chat3j.client.Chat3JNode;
import chat3j.messages.RequestForTopicListMsg;
import com.esotericsoftware.kryonet.Connection;

/**
 * 토픽 리스트를 요청한 후 마스터로부터 답신을 받은 경우 생성됨
 */
public class TopicListCommand extends PostCommand {

    public TopicListCommand(Connection conn, RequestForTopicListMsg msg) {
        super(conn, msg);
    }

    @Override
    public void exec(Chat3JNode node) {
        RequestForTopicListMsg response = (RequestForTopicListMsg) msg;

        // 토픽 리스트 로깅
        node.logger.info("=== TOPIC ===");
        for (String t: response.topic)
            node.logger.info(t);
        node.logger.info("=============");

        // 토픽 리스트 리턴
        node.optionOk(response.optionId, response.topic, "Success.");
    }
}
