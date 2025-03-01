package ashburncode.sbapp2717g;

import io.swagger.v3.oas.annotations.Operation;
import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

//import io.swagger.v3.oas.annotations.Operation;
//import java.util.*;
//import java.io.IOException;

@RestController
public class DemojaxbController {

	@Operation(summary = "demojaxbmarshaller value string", description = "demojaxbmarshaller notes string")
	@GetMapping("/demojaxbmarshaller")
	public String demojaxbmarshaller() {
		Book book = new Book();
		book.setId(1L);
		book.setName("Book1");
		book.setAuthor("Author1");
		// book.setDate(new Date());
		return marshalbook(book);
	}

	@Operation(summary = "demojaxbunmarshaller value string", description = "demojaxbunmarshaller notes string")
	@GetMapping("/demojaxbunmarshaller")
	public String demojaxbunmarshaller() {

		String bookxml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "  <book id=\"1\">"
				+ "    <name>Book1</name>" + "    <author>Author1</author>" + "  </book>";
		return unmarshalbook(bookxml);
	}

	// public String marshal(Book book) throws JAXBException, IOException {}
	public String marshalbook(Book book) {
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

	// public String marshal(Book book) throws JAXBException, IOException {}
	public String unmarshalbook(String bookxml) {
		String retval = "demo of jaxb unmarshaller";
		try {
			JAXBContext context = JAXBContext.newInstance(Book.class);
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			Book book = (Book) jaxbUnmarshaller.unmarshal((new StringReader(bookxml)));
			retval = book.toString();
		} catch (JAXBException ex) {
			retval = ex.getMessage();
			System.err.println("JAXBException: " + ex.getMessage());
			ex.printStackTrace();
		}
		return retval;
	}

}
