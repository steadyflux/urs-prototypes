package com.raytheon.eosdis.urs.ws;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.raytheon.eosdis.urs.service.HelloSoapResourceService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Endpoint
public class HelloSoapEndpoint {
  private static final String NAMESPACE_URI = "http://raytheon.com/urs/schemas";
  
  public static final String URS_REQUEST_LOCAL_NAME = "URSRequest";
  public static final String URS_RESPONSE_LOCAL_NAME = "URSResponse";

  private final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
  
  private HelloSoapResourceService helloSoapResourceService;
  
  private static final Log logger = LogFactory.getLog(HelloSoapEndpoint.class);
  
  @Autowired
  public HelloSoapEndpoint(HelloSoapResourceService helloSoapResourceService) {
	  logger.info("&&&&&&&&&&&&Entering HelloSoapEndpoint constructor");
      this.helloSoapResourceService = helloSoapResourceService;
      logger.info("&&&&&&&&&&&&Exiting HelloSoapEndpoint constructor");
  }
  
//  @PayloadRoot(localPart = URS_REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
//  @ResponsePayload
//  public Element handleURSRequest(@RequestPayload Element requestElement) throws ParserConfigurationException {
//	  
//	  logger.info("******************Entering handleURSRequest");
//      
//	  logger.info(requestElement.toString());
//	  NodeList children = requestElement.getChildNodes();
//      Text requestText = null;
//      for (int i = 0; i < children.getLength(); i++) {
//          if (children.item(i).getNodeType() == Node.TEXT_NODE) {
//              requestText = (Text) children.item(i);
//              break;
//          }
//      }
//      if (requestText == null) {
//          throw new IllegalArgumentException("Could not find request text node");
//      }
//
//      String name = requestText.getNodeValue();
//	  
//      helloSoapResourceService.authenticate(name, name);
//      
//      logger.info("Received Request: " + name + ", " + name);
//      
//      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//      Document document = documentBuilder.newDocument();
//      Element responseElement = document.createElementNS(NAMESPACE_URI, URS_RESPONSE_LOCAL_NAME);
//      Text responseText = document.createTextNode(name + "::::::::" + name);
//      responseElement.appendChild(responseText);
//      
//      logger.info("*****************Exiting handleURSRequest");
//      
//      return responseElement;
//  }
}