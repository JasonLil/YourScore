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
 * <p>Java class for stick-location.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stick-location">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="center"/>
 *     &lt;enumeration value="rim"/>
 *     &lt;enumeration value="cymbal bell"/>
 *     &lt;enumeration value="cymbal edge"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stick-location")
@XmlEnum
public enum StickLocation {

    @XmlEnumValue("center")
    CENTER("center"),
    @XmlEnumValue("rim")
    RIM("rim"),
    @XmlEnumValue("cymbal bell")
    CYMBAL_BELL("cymbal bell"),
    @XmlEnumValue("cymbal edge")
    CYMBAL_EDGE("cymbal edge");
    private final String value;

    StickLocation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StickLocation fromValue(String v) {
        for (StickLocation c: StickLocation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
