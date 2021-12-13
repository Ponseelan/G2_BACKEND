package com.example.G2.Model;

import lombok.Getter;

@Getter
public class ActionResult {
    String action;
    String entity;
    String entityUniqueId;
    Object Value;
    ActionResultStatus status;

    public ActionResult(String action, String entity, String entityUniqueId, Object value,ActionResultStatus status) {
        this.action = action;
        this.entity = entity;
        this.entityUniqueId = entityUniqueId;
        Value = value;
        this.status=status;
    }

    public static ActionResult create(String action, String entity, String entityUniqueId, Object value,ActionResultStatus status) {
       return new ActionResult(action,entity,entityUniqueId,value,status);
    }
}
