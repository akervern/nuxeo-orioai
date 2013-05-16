package org.orioai.esupecm.workflow;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ecm.core.api.impl.blob.ByteArrayBlob;
import org.nuxeo.ecm.core.api.impl.blob.StringBlob;
import org.nuxeo.ecm.core.repository.jcr.testing.RepositoryOSGITestCase;
import org.nuxeo.runtime.api.Framework;
import org.orioai.esupecm.nuxeo2xml.service.OriOaiNuxeo2XmlService;
import org.orioai.esupecm.nuxeo2xml.service.OriOaiNuxeo2XmlServiceImpl;


public class TestOriOaiNuxeo2XmlService extends TestAbstractDocument {

	protected OriOaiNuxeo2XmlService service;
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = Framework.getService(OriOaiNuxeo2XmlService.class);
    }
    
    public void testServiceRegistration() throws Exception {
        assertNotNull(service);
//        Map<String, URL> xslMap = null;
//        //(Map<String, URL>)((OriOaiNuxeo2XmlServiceImpl)service).getXslMap();
//        assertFalse("xslMap is empty ! :-(", xslMap.isEmpty());
    }
    
    public void testDocToXml() throws Exception {
    	DocumentModel doc =  coreSession.getDocument(createSampleFile());
    	//service.docToXml(coreSession, doc, "document");
    }

}

