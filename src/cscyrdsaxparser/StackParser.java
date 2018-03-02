/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscyrdsaxparser;


import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javafx.fxml.FXML;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author claytoncornett
 */
public class StackParser {
    
    
    
   private static Node root;
    private static Stack<Node> stack;
    private static Node current;
    
    private static String xmlString;
    
    public static Node parse(File file) throws Exception {
        try {
            
           xmlString = "";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
             DefaultHandler handler = new DefaultHandler() {
                 @Override
                 public void startDocument() throws SAXException {
                     root = null;
                     stack = new Stack<>();
                }
                 
                 @Override
                 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                     Node node = new Node();
                     
                     node.name = qName;
                     
                     xmlString += node.name + "\n";
                     
                     
//                    
                     
                     node.attributes = new HashMap();
                     int size = attributes.getLength();
                     
                     for (int i = 0; i < size; i++) {
                         node.attributes.put(attributes.getQName(i), attributes.getValue(i));
                     }
                     stack.push(node);
                     
                     if (current != null) {
                         if (current.children == null) {
                             current.children = new ArrayList();
                         }
                             current.children.add(node);
                         
                     }
                     current = node; 
                 } // end start element
                 
                 @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    current.data = new String(ch, start, length);
                    
                    xmlString += current.data + "\n";
                    
                }
                 @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    Node popped = stack.pop();
                    if (popped != null) {
                        if (stack.empty()) {
                            root = popped;
                            current = null;
                        } else {
                            current = stack.peek();
                        }
                    }
                }
             };
             
             saxParser.parse(file.getAbsoluteFile(), handler);
             
        } catch (Exception e) {
            throw e;
        }
        
        return root;
    }
    
    static String createText(){
        return StackParser.xmlString;
    }
    
}
