package com.jaemon.dingtalk.listeners;

import com.jaemon.dingtalk.DingTalkSender;
import com.jaemon.dingtalk.entity.DingTalkProperties;
import com.jaemon.dingtalk.entity.DingTalkResult;
import com.jaemon.dingtalk.entity.message.MsgType;
import com.jaemon.dingtalk.support.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

import static com.jaemon.dingtalk.constant.DkConstant.DK_PREFIX;
import static com.jaemon.dingtalk.constant.DkConstant.FAILED_KEYWORD;

/**
 * Failed Listener
 *
 * @author Jaemon@answer_ljm@163.com
 * @version 1.0
 */
public class FailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
    private static final Logger log = LoggerFactory.getLogger(FailedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        if (applicationContext == null) {
            return;
        }

        DingTalkProperties properties = applicationContext.getBean(DingTalkProperties.class);

        if (properties.isEnabled()
                && properties.getMonitor().isFalied()) {
            DingTalkSender dingTalkRobot = applicationContext.getBean(DingTalkSender.class);
            Notification notification = applicationContext.getBean(Notification.class);
            String projectId = properties.getProjectId();
            projectId = projectId == null ? DK_PREFIX : projectId;

            ApplicationEventTimeTable.failedTime = event.getTimestamp();

            MsgType message = notification.failed(event, projectId);
            String keyword = projectId + FAILED_KEYWORD;
            DingTalkResult result = dingTalkRobot.send(keyword, message);
            if (log.isDebugEnabled()) {
                log.debug("keyword={}, result={}.", keyword, result.toString());
            }
        }
    }

}