package org.orioai.esupecm.workflow;

import org.jboss.seam.annotations.In;
import org.junit.Ignore;
import org.junit.Test;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.orioai.esupecm.relations.OriOaiRelationActionsBean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TestOriOaiRelations extends TestAbstractDocument{
	
	@In(create = true)
	private OriOaiRelationActionsBean referencingManager;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		//referencingManager = Framework.get();
	}

    @Test
    @Ignore
	public void testCreateRelation() throws Exception {
		
		assertNotNull(referencingManager);
    	DocumentModel doc =  coreSession.getDocument(createSampleFile());
    	String oriId = "oriId#" + String.valueOf(random.nextLong());
    	String result = referencingManager.createOriRelation(oriId, doc, "label de test");
    	assertFalse("relation not created :-(",  ! "ori_view".equals(result));
    	
    }

	
}
