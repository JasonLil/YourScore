import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import javax.swing.*;
import java.awt.*;


/**
 * Created by boyd on 5/4/15.
 */
public class Display extends JFrame{
    private JPanel rootPanel;
    private JSVGCanvas canvas;
    private DOMImplementation dom;
    private SVGGraphics2D generator;
    private SVGDocument document;
    private String svgNS;


    Display(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(this.rootPanel);

        setContentPane(scrollPane);
        setVisible(true);

        this.rootPanel.setLayout(new BorderLayout());
        this.canvas = new JSVGCanvas();
        this.canvas.setMySize(new Dimension(1000,1000));


        this.dom = SVGDOMImplementation.getDOMImplementation();
        this.svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        this.document = (SVGDocument)this.dom.createDocument(svgNS,"svg", null);
        this.generator = new SVGGraphics2D(this.document);
        this.createStaves();
        this.rootPanel.add("Center",this.canvas);
        pack();

    }

    public void createStaves(){
        Element root = this.document.getDocumentElement();
        root.setAttributeNS(null,"width","1000");
        root.setAttributeNS(null, "height", "1000");

        Integer breakBetween = 10;
        for(int i = 0;i<4;i++) {

            for (int k = 0; k < 5; k++) {

                Integer y1 = k*(20) + breakBetween;
                Integer y2 = k*(20) + breakBetween;
                Integer x1 = 0;
                Integer x2 = 1000;
                Element line = this.document.createElementNS(this.svgNS, "line");

                line.setAttributeNS(null, "x1", x1.toString());
                line.setAttributeNS(null,"x2", x2.toString());
                line.setAttributeNS(null,"y1", y1.toString());
                line.setAttributeNS(null, "y2", y2.toString());
                line.setAttributeNS(null,"stroke","black");
                line.setAttributeNS(null,"stroke-width","1");

                root.appendChild(line);

            }
            breakBetween+=130;
        }
        this.generator.getRoot(root);
        this.canvas.setSVGDocument(this.document);

    }


}