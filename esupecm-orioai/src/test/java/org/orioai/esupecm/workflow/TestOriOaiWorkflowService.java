package org.orioai.esupecm.workflow;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.NXRuntimeTestCase;
import org.orioai.esupecm.OriOaiMetadataType;
import org.orioai.esupecm.workflow.service.OriOaiWorkflowService;

import static org.junit.Assert.assertNotNull;


public class TestOriOaiWorkflowService extends NXRuntimeTestCase {

	private OriOaiWorkflowService service;
	 
    private static final String OSGI_BUNDLE_NAME = "org.orioai.nuxeo.workflow";

    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        // deployment of the whole ori-oai-nuxeo-project bundle
        deployBundle(OSGI_BUNDLE_NAME);

        service = Framework.getService(OriOaiWorkflowService.class);
    }

    @Test
    public void testServiceRegistration() throws Exception {
        assertNotNull(service);
    }

    @Test
    @Ignore
    public void testGetMetadataTypes() throws Exception {     
    	List<OriOaiMetadataType> metadataTypes = service.getMetadataTypes("admin");
        assertNotNull("metadataTypes obtained from OriOaiWorkflowService is null ??", metadataTypes);
    }

}

