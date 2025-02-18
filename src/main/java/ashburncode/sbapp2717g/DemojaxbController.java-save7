package ashburncode.sbapp2717g;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.io.IOException;
import java.io.StringWriter;
import ashburncode.sbapp2717g.Book;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.JAXBException;

@RestController
public class DemojaxbController {

  @Operation(summary = "demojaxbmarshaller value string",
                description = "demojaxbmarshaller notes string") 
  @GetMapping("/demojaxbmarshaller")
  public String demojaxb() {
    Book book = new Book();
    book.setId(1L);
    book.setName("Book1");
    book.setAuthor("Author1");
    // book.setDate(new Date());
    return marshal(book);
  }

  // public String marshal(Book book) throws JAXBException, IOException {}
  public String marshal(Book book) {
    String retval = "demo of jaxb marshaller";
    try {
      JAXBContext context = JAXBContext.newInstance(Book.class);
      Marshaller jaxbMarshaller = context.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      // mar.marshal(book, System.out);
      // mar.marshal(book, new File("./book.xml"));
      // Use a StringWriter to capture the output
      StringWriter sw = new StringWriter();
      // Marshal the object to the StringWriter
      jaxbMarshaller.marshal(book, sw);
      // Get the XML string from the StringWriter
      retval = sw.toString();
    } catch (JAXBException ex) {
      retval = ex.getMessage();
      System.err.println("JAXBException: " + ex.getMessage());
      ex.printStackTrace();
    }
    return retval;
  }

}

// public class Example {

// public static void main(String[] args) {
// try {
// JAXBContext context = JAXBContext.newInstance(Customer.class);
// Marshaller marshaller = context.createMarshaller();
// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

// Customer customer = new Customer("John", "Doe");
// marshaller.marshal(customer, System.out);

// } catch (JAXBException e) {
// System.err.println("JAXBException: " + e.getMessage());
// e.printStackTrace();
// }
// }
// }
