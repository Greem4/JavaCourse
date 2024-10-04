package com.greem4.spring.lestner.entity;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class EntityEvent extends ApplicationEvent {

    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
