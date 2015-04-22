package MusicXML;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 03:34:39 PM CDT 
//


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The bar-style-color type contains barline style and color information.
 * 
 * <p>Java class for bar-style-color complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bar-style-color">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>bar-style">
 *       &lt;attGroup ref="{}color"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bar-style-color", propOrder = {
    "value"
})
public class BarStyleColor {

    @XmlValue
    protected BarStyle value;
    @XmlAttribute(name = "color")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String color;

    /**
     * The bar-style type represents barline style information. Choices are regular, dotted, dashed, heavy, light-light, light-heavy, heavy-light, heavy-heavy, tick (a short stroke through the top line), short (a partial barline between the 2nd and 4th lines), and none.
     * 
     * @return
     *     possible object is
     *     {@link BarStyle }
     *     
     */
    public BarStyle getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BarStyle }
     *     
     */
    public void setValue(BarStyle value) {
        this.value = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

}
