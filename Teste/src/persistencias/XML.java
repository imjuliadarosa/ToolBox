/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Julia
 */
public class XML implements Persistencia {

    @Override
    public void gravar(String corpo) {
        System.out.println("Gravando...");
        try{
        DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBF.newDocumentBuilder();
        Document documentoXML = documentBuilder.newDocument();
        //<registro>
        Element registro = documentoXML.createElement("registro");
        documentoXML.appendChild(registro);
        //<caixaTexto>
        Element caixaTexto = documentoXML.createElement("caixaTexto");
        registro.appendChild(caixaTexto);
        //<texto> "corpo"
        Attr texto = documentoXML.createAttribute("texto");
        texto.setValue(corpo);
        caixaTexto.setAttributeNode(texto);
        //
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(registro);

        StreamResult streamResult = new StreamResult(new File("registro.xml"));

        transformer.transform(source, streamResult);
        System.out.print("Gravado em XML com sucesso!");
        
        }catch(ParserConfigurationException | TransformerException ex){
            System.err.printf("Erro na criação do arquivo em XML : %s.\n", ex.getMessage());
        }
    }

    @Override
    public String ler() {
        System.out.println("Lendo...");
        String corpo="";
        try {
        File xmlFile = new File("registro.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document;
        document = documentBuilder.parse(xmlFile);
        NodeList list = document.getElementsByTagName("caixaTexto");
        for(int i =0;i<list.getLength();i++){
            Node node = list.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element element = (Element) node;
                corpo += element.getAttribute("texto");
            }
        }
        System.out.println("Lido de XML com sucesso!");
        return corpo;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.err.printf("Erro na abertura do arquivo em XML : %s.\n" , ex.getMessage());
            return null;
        }
    }
    
    
}
