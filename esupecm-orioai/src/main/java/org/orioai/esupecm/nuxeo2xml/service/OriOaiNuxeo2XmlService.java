package org.orioai.esupecm.nuxeo2xml.service;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;

public interface OriOaiNuxeo2XmlService {

    String mergeXmlDoc(CoreSession session, DocumentModel version, String blobXpath, String lomBlobXpath, String wkfXmlDocument);

	String mergeXmlDoc(CoreSession documentManager, DocumentModel doc, String metadataSchemaNamespace, String originalXml) throws ClientException;

    String getLastVersionUrl();
}
