/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscyrdsaxparser;

import com.sun.deploy.xml.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author claytoncornett
 */
public class Node {
    
    public String name;
    public String data;
    public HashMap<String, String> attributes;
    public ArrayList<Node> children;
    
    public Node() {}
}
