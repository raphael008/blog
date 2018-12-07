package com.github.raphael008.auth;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.apache.commons.lang3.StringUtils;
import org.springframework.session.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class CustomHttpSessionStrategy /*implements HttpSessionStrategy*/ {

    private String sessionPrefix = "spring:session:";
    private Long maxInactiveIntervalInSeconds = 999L;

    private StatefulRedisConnection<String, String> connection;

    public CustomHttpSessionStrategy() {
        RedisClient redisClient = RedisClient.create("redis://127.0.0.1:6379");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
    }

//    @Override
    public String getRequestedSessionId(HttpServletRequest httpServletRequest) {
        RedisCommands<String, String> commands = connection.sync();

        String userId = httpServletRequest.getParameter("userId");
        if (StringUtils.isNotBlank(userId)) {
            String session = commands.get(sessionPrefix + userId);
            return session;
        }
        return null;
    }

//    @Override
    public void onNewSession(Session session, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String userId = httpServletRequest.getParameter("userId");
        String sessionId = session.getId();

        RedisCommands<String, String> commands = connection.sync();

        if (Objects.nonNull(userId)) {
            String k = sessionPrefix + userId;
            String v = sessionId;
            commands.set(k, v);
            commands.expire(k, maxInactiveIntervalInSeconds);
        }

    }

//    @Override
    public void onInvalidateSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String userId = httpServletRequest.getParameter("userId");
        RedisCommands<String, String> commands = connection.sync();
        commands.expire(sessionPrefix + userId, 0);
    }
}
