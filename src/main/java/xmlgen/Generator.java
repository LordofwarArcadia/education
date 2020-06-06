package xmlgen;

import xmlgen.model.InsAmout;
import xmlgen.model.Operation;
import xmlgen.model.TotalAmount;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Generator {

    public static void main(String[] args) {
        new Generator();
    }

    public Generator() {
        Operation op = new Operation();
        op.setSPName("TEST1");
        InsAmout insAmout = new InsAmout();
        TotalAmount ta = new TotalAmount();
        ta.setInsAmoutValue("123456");
        insAmout.setTotalAmount(ta);
        op.setInsAmout(insAmout);

        jaxbObjectToXML(op);
    }

    private static void jaxbObjectToXML(Operation operation) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Operation.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(operation, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println(xmlContent);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
