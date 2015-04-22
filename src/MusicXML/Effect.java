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
 * <p>Java class for effect.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="effect">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="anvil"/>
 *     &lt;enumeration value="auto horn"/>
 *     &lt;enumeration value="bird whistle"/>
 *     &lt;enumeration value="cannon"/>
 *     &lt;enumeration value="duck call"/>
 *     &lt;enumeration value="gun shot"/>
 *     &lt;enumeration value="klaxon horn"/>
 *     &lt;enumeration value="lions roar"/>
 *     &lt;enumeration value="police whistle"/>
 *     &lt;enumeration value="siren"/>
 *     &lt;enumeration value="slide whistle"/>
 *     &lt;enumeration value="thunder sheet"/>
 *     &lt;enumeration value="wind machine"/>
 *     &lt;enumeration value="wind whistle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "effect")
@XmlEnum
public enum Effect {

    @XmlEnumValue("anvil")
    ANVIL("anvil"),
    @XmlEnumValue("auto horn")
    AUTO_HORN("auto horn"),
    @XmlEnumValue("bird whistle")
    BIRD_WHISTLE("bird whistle"),
    @XmlEnumValue("cannon")
    CANNON("cannon"),
    @XmlEnumValue("duck call")
    DUCK_CALL("duck call"),
    @XmlEnumValue("gun shot")
    GUN_SHOT("gun shot"),
    @XmlEnumValue("klaxon horn")
    KLAXON_HORN("klaxon horn"),
    @XmlEnumValue("lions roar")
    LIONS_ROAR("lions roar"),
    @XmlEnumValue("police whistle")
    POLICE_WHISTLE("police whistle"),
    @XmlEnumValue("siren")
    SIREN("siren"),
    @XmlEnumValue("slide whistle")
    SLIDE_WHISTLE("slide whistle"),
    @XmlEnumValue("thunder sheet")
    THUNDER_SHEET("thunder sheet"),
    @XmlEnumValue("wind machine")
    WIND_MACHINE("wind machine"),
    @XmlEnumValue("wind whistle")
    WIND_WHISTLE("wind whistle");
    private final String value;

    Effect(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Effect fromValue(String v) {
        for (Effect c: Effect.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}