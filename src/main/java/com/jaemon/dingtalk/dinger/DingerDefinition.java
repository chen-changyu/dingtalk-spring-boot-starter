/*
 * Copyright 2015-2020 Jaemon(answer_ljm@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jaemon.dingtalk.dinger;

import com.jaemon.dingtalk.dinger.entity.DingerType;
import com.jaemon.dingtalk.entity.enums.MsgTypeEnum;
import com.jaemon.dingtalk.entity.message.Message;


/**
 * DingerDefinition
 *
 * @author Jaemon#answer_ljm@163.com
 * @version 2.0
 */
public interface DingerDefinition {

    /**
     * getKeyName
     *
     * @return keyName
     */
    String keyName();

    /**
     * setKeyName
     *
     * @param keyName keyName
     */
    void setKeyName(String keyName);

    /**
     * getMsgType
     *
     * @return msgType
     */
    MsgTypeEnum msgType();

    /**
     * setMsgType
     *
     * @param msgType msgType
     */
    void setMsgType(MsgTypeEnum msgType);

    /**
     * getMessage
     *
     * @return message
     */
    Message message();

    /**
     * setMessage
     *
     * @param message message
     */
    void setMessage(Message message);

    /**
     * dingerConfig
     *
     * @return dingerConfig
     */
    DingerConfig dingerConfig();

    /**
     * dingerConfig
     *
     * @param dingerConfig dingerConfig
     */
    void setDingerConfig(DingerConfig dingerConfig);

    /**
     * dingerType
     *
     * @return dingerType
     */
    DingerType dingerType();

    /**
     * setDingerType
     *
     * @param dingerType dingerType
     */
    void setDingerType(DingerType dingerType);

}