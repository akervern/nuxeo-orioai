package org.orioai.esupecm.workflow;

import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.NXRuntimeTestCase;
import org.orioai.esupecm.workflow.service.OriOaiWorkflowService;

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

    public void testServiceRegistration() throws Exception {
        assertNotNull(service);
    }

    public void testGetMetadataTypes() throws Exception {
        // List<OriOaiMetadataType> metadataTypes =
        // service.getMetadataTypes("admin");
        // assertNotNull("metadataTypes obtained from OriOaiWorkflowService is null ??",
        // metadataTypes);
    }

}
