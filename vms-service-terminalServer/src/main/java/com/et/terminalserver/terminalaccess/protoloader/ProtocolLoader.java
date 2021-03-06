package com.et.terminalserver.terminalaccess.protoloader;/**
 * Created by gaop on 2017/8/21.
 */

import com.et.terminalserver.common.util.xml.XmlElement;
import com.et.terminalserver.common.util.xml.XmlException;
import com.et.terminalserver.common.util.xml.XmlParser;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.ProtocolAnalysis;
import com.et.terminalserver.protocols.protocols.common.ProtocolAnalysisManager;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/21 11:35
 */
public class ProtocolLoader{
    private XmlParser xmlParser;
    private XmlElement rootElement;
    //private String xmlPath="vms-service-terminalServer/src/listener/resources/protocolConfig.xml";
     private Resource resource;

    public void init(){
           loadProtocol(resource);
    }

    public void loadProtocol(Resource resource){
        try {
            xmlParser=new XmlParser(resource.getInputStream());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rootElement=xmlParser.parse();
           List<XmlElement> list=rootElement.getChildElements("protocol");
          for(XmlElement element:list){
              String protocolName=element.getAttribute("protocolname");
              ProtocolAnalysis<MessageHeader,MessageBody> analysis= (ProtocolAnalysis<MessageHeader,MessageBody>)Class.forName(element.getAttribute("protocolclass")).newInstance();
              ProtocolAnalysisManager.addProtocol(protocolName, analysis);
          }
        }
       catch (XmlException e){
            e.printStackTrace();
       } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
