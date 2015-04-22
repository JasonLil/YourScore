package MusicXML;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 03:34:39 PM CDT 
//


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Works are optionally identified by number and title. The work type also may indicate a link to the opus document that composes multiple scores into a collection.
 * 
 * <p>Java class for work complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="work">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="work-number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="work-title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="opus" type="{}opus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "work", propOrder = {
    "workNumber",
    "workTitle",
    "opus"
})
public class Work {

    @XmlElement(name = "work-number")
    protected String workNumber;
    @XmlElement(name = "work-title")
    protected String workTitle;
    protected Opus opus;

    /**
     * Gets the value of the workNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * Sets the value of the workNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkNumber(String value) {
        this.workNumber = value;
    }

    /**
     * Gets the value of the workTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkTitle() {
        return workTitle;
    }

    /**
     * Sets the value of the workTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkTitle(String value) {
        this.workTitle = value;
    }

    /**
     * Gets the value of the opus property.
     * 
     * @return
     *     possible object is
     *     {@link Opus }
     *     
     */
    public Opus getOpus() {
        return opus;
    }

    /**
     * Sets the value of the opus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Opus }
     *     
     */
    public void setOpus(Opus value) {
        this.opus = value;
    }

}