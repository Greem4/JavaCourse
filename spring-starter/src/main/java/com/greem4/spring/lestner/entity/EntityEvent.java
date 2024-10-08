package com.greem4.spring.lestner.entity;

import lombok.Getter;

import java.util.EventObject;

@Getter
public class EntityEvent extends EventObject {

    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }
}
