package com.raytheon.eosdis.urs.ws;

import javax.xml.transform.sax.SAXSource;

import org.xml.sax.SAXException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.raytheon.eosdis.urs.service.HelloSoapResourceService;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

@Endpoint
public class HelloSoapEndpoint2 {
  private static final String NAMESPACE_URI = "http://raytheon.com/urs/schemas";
  
  public static final String URS_REQUEST_LOCAL_NAME = "URSRequest";
  public static final String URS_RESPONSE_LOCAL_NAME = "URSResponse";
  
  private HelloSoapResourceService helloSoapResourceService;
  
//  private static final Log logger = LogFactory.getLog(HelloSoapEndpoint.class);
  
  @Autowired
  public HelloSoapEndpoint2(HelloSoapResourceService helloSoapResourceService) {
      this.helloSoapResourceService = helloSoapResourceService;
  }
  
  @PayloadRoot(localPart = URS_REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
  @ResponsePayload
  public SAXSource handleURSRequest(@RequestPayload SAXSource requestElement) throws SAXException {
	 
      String name = "parrot";
      
      helloSoapResourceService.authenticate(name, name);
            
      return requestElement;
  }
}