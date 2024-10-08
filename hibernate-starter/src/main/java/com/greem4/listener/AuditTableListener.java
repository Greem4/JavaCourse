package com.greem4.listener;

import com.greem4.entity.Audit;
import org.hibernate.event.spi.*;


public class AuditTableListener implements PreDeleteEventListener, PreInsertEventListener {

    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        auditEntity(event, Audit.Operation.DELETE);
        return false;
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        auditEntity(event, Audit.Operation.INSERT);
        return false;
    }

    public void auditEntity(AbstractPreDatabaseOperationEvent event, Audit.Operation operation) {
        if (event.getEntity().getClass() != Audit.class) {
            var audit = Audit.builder()
                    .entityId(event.getId())
                    .entityName(event.getEntityName())
                    .entityContent(event.getEntity().toString())
                    .operation(operation)
                    .build();
            event.getSession().save(audit);
        }
    }
}
