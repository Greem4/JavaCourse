package com.greem4.listener;

import com.greem4.entity.Revision;
import org.hibernate.envers.RevisionListener;

public class Greem4RevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        ((Revision) revisionEntity).setUserName("greem");
    }
}
