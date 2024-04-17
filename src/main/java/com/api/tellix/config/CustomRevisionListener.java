package com.api.tellix.config;

import com.api.tellix.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener  implements RevisionListener{
    public void newRevision(Object revisionEntity) {final Revision revision = (Revision) revisionEntity;}
    
}
