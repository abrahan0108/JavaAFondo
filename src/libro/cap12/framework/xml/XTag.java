package libro.cap12.framework.xml;

import libro.cap09.Hashtable2;

import java.util.*;

public class XTag {

    private String name;
    private Hashtable<String, String> atts;
    private Hashtable2<XTag> subtags;

    public XTag(String qname, Hashtable<String, String> atts){
        this.name = qname;
        this.atts = atts;
        subtags = new Hashtable2<XTag>();
    }

    public void addSubtag(XTag t){
        subtags.put(t.getName(), t);
    }

    public String toString() {
        String x = name + " (";
        String aux;
        int i = 0;
        for (Enumeration<String> e = atts.keys(); e.hasMoreElements();){
            aux = e.nextElement();
            x+=aux+"="+atts.get(aux)+(i++<atts.size()-1?",":") ");
        }
        return x;
    }

    public boolean equals(Object obj){
        return name.equals(((XTag) obj).name);
    }

    public XTag getSubtag(String name){
        String auxNAme;

        // si el pathname es absoluto lo convertimos en relativo
        if(name.startsWith("/"+this.name+"/")){
            auxNAme = name.substring(this.name.length()+2);
        }
        else{
            auxNAme = name;
        }

        StringTokenizer st = new StringTokenizer(auxNAme, "/");

        XTag dum = this;
        String tok;
        while(st.hasMoreTokens()){
            tok = st.nextToken();
            dum = dum.subtags.get(tok).getFirst();
        }
        return dum;
    }

    public XTag[] getSubtags(String name){
        String auxName;
        String auxNAme2;
        int idx = name.lastIndexOf("/");

        LinkedList<XTag> hijos;

        if(idx>0){
            auxName=name.substring(0,idx);
            auxNAme2=name.substring(idx+1);

            XTag tag = getSubtag(auxName);
            hijos = tag.subtags.get(auxNAme2);
        }
        else {
            hijos=subtags.get(name);
        }

        int i = 0;
        XTag[] t = new XTag[hijos.size()];
        for (Iterator<XTag>it = hijos.iterator();it.hasNext();){
            t[i++] = it.next();
        }

        return t;
    }

    public XTag getSubtagByAttribute(String path,
                                     String attName,
                                     String value){
        XTag[] tags = getSubtags(path);
        for (int i = 0; i<tags.length;i++){
            if(tags[i].atts.get(attName).equals(value)){
                return tags[i];
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable<String, String> getAtts() {
        return atts;
    }

    public void setAtts(Hashtable<String, String> atts) {
        this.atts = atts;
    }


}
