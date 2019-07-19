package libro.cap12.framework.test;

import libro.cap12.framework.xml.XMLFactory;
import libro.cap12.framework.xml.XTag;

public class TestXML2 {
    public static void main(String[] args){
        // leemos el archivo y lo cargamos en memoria
        XMLFactory.load("configuracion.xml");

        // accedo altag especificando su ruta
        String path = "/framework/data-access/mapping/table";
        String attName = "name";
        String attValue = "EMP";
        XTag tag = XMLFactory.getByAttribute(path, attName, attValue);

        // accedo a los valores de sus atributos
        String type = tag.getAtts().get("type");
        System.out.println(type);

        // accedo a los valores de sus subtags
        XTag[] fields = tag.getSubtags("field");
        for(int i = 0; i < fields.length; i++){
            System.out.println(fields[i]);
        }
    }
}
