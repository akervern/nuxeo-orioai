package org.orioai.esupecm.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.jboss.seam.annotations.In;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.orioai.esupecm.relations.OriOaiRelationActionsBean;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@RepositoryConfig(init = DefaultRepositoryInit.class)
@Deploy({ TestAbstractDocument.OSGI_BUNDLE_NAME })
public class TestOriOaiRelations extends TestAbstractDocument {

    @In(create = true)
    private OriOaiRelationActionsBean referencingManager;

    @Test
    @Ignore
    public void testCreateRelation() throws Exception {

        assertNotNull(referencingManager);
        DocumentModel doc = coreSession.getDocument(createSampleFile());
        String oriId = "oriId#" + String.valueOf(random.nextLong());
        String result = referencingManager.createOriRelation(oriId, doc,
                "label de test");
        assertFalse("relation not created :-(", !"ori_view".equals(result));

    }

}
