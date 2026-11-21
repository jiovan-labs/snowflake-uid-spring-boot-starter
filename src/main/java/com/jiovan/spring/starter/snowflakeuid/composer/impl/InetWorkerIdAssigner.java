/*
 * Copyright (c) 2020 Jiovan Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jiovan.spring.starter.snowflakeuid.composer.impl;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.jiovan.plexus.common.toolkit.util.InetAddressWraps;
import com.jiovan.plexus.spring.toolkit.util.ApplicationContextWraps;
import com.jiovan.spring.starter.snowflakeuid.composer.WorkerIdAssigner;
import com.jiovan.spring.starter.snowflakeuid.exception.UidGenerationException;
import com.jiovan.spring.starter.snowflakeuid.property.SnowflakeUidProperties;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


/**
 * Composer implementation for {@link com.jiovan.spring.starter.snowflakeuid.composer.WorkerIdAssigner} by INet
 *
 * @author David Hsing
 */
@RequiredArgsConstructor
@Slf4j
public class InetWorkerIdAssigner implements WorkerIdAssigner, ApplicationContextAware, InitializingBean {
    private final SnowflakeUidProperties uidProperties;
    private Long inet4Port;

    @Setter
    protected ApplicationContext applicationContext;

    @Override
    @SuppressWarnings("RedundantThrows")
    public void afterPropertiesSet() throws Exception {
        inet4Port = InetAddressWraps.toLongByInet4Port(InetAddressWraps.getLocalIpAddress(), ApplicationContextWraps.getLocalServerPort(applicationContext));
    }

    /**
     * Generates the worker id from the configured inet4 port masked to the number of worker id bits
     *
     * @return the generated worker id, or {@code 0} if no inet4 port is configured
     *
     * @throws com.jiovan.spring.starter.snowflakeuid.exception.UidGenerationException if the worker id cannot be generated
     */
    public long generateWorkerId() throws UidGenerationException {
        if (inet4Port == null) {
            return 0L;
        }
        int shift = 64 - uidProperties.getWorkerBits();
        long workerId = (inet4Port << shift) >>> shift;
        if (log.isDebugEnabled()) {
            log.debug("Generated worker id = '{}'", workerId);
        }
        return workerId;
    }
}
