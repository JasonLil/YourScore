package MusicXML;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 03:34:39 PM CDT 
//


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for upright-inverted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="upright-inverted">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="upright"/>
 *     &lt;enumeration value="inverted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "upright-inverted")
@XmlEnum
public enum UprightInverted {

    @XmlEnumValue("upright")
    UPRIGHT("upright"),
    @XmlEnumValue("inverted")
    INVERTED("inverted");
    private final String value;

    UprightInverted(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UprightInverted fromValue(String v) {
        for (UprightInverted c: UprightInverted.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
