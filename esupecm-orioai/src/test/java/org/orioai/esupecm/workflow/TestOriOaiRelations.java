package org.orioai.esupecm.workflow;

import org.jboss.seam.annotations.In;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.runtime.api.Framework;
import org.orioai.esupecm.relations.OriOaiRelationActionsBean;

public class TestOriOaiRelations extends TestAbstractDocument{
	
	@In(create = true)
	private OriOaiRelationActionsBean referencingManager;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		//referencingManager = Framework.get();
	}
	
	public void testCreateRelation() throws Exception {
		
//		assertNotNull(referencingManager);
//    	DocumentModel doc =  coreSession.getDocument(createSampleFile());
//    	String oriId = "oriId#" + String.valueOf(random.nextLong());
//    	String result = referencingManager.createOriRelation(oriId, doc, "label de test");
//    	 assertFalse("relation not created :-(",  ! "ori_view".equals(result));
    	
    }

	
}