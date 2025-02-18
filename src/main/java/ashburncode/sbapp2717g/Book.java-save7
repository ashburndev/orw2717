package ashburncode.sbapp2717g;

// import jakarta.xml.bind.JAXBContext;
// import jakarta.xml.bind.JAXBException;
// import jakarta.xml.bind.Marshaller;
// import jakarta.xml.bind.Unmarshaller;
// import jakarta.xml.bind.XmlRootElement;
// import jakarta.xml.bind.XmlType;

// import jakarta.xml.bind.annotation.*;

// import jakarta.xml.bind.annotation.JAXBContext;
// import jakarta.xml.bind.annotation.Marshaller;
// import jakarta.xml.bind.annotation.Unmarshaller;
// import jakarta.xml.bind.annotation.JAXBException;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.JAXBException;

// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.ToString;

import java.util.Date;

// @Data
@XmlRootElement(name = "book")
// @XmlRootElement(name = "employee")
// @XmlRootElement(name = "company")
// @XmlType(propOrder = { "id", "name", "date" })
@XmlType(propOrder = { "id", "name", "author" })
public class Book {
    private Long id;
    private String name;
    private String author;
    // private Date date;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "author")
    public void setAuthor(String author) {
        this.author = author;
    }

    // @XmlElement(name = "date")
    // public void setDate(Date date) {
    //     this.date = date;
    // }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    // public String getDate() {
    //     return date;
    // }

    // @XmlTransient
    // public void setAuthor(String author) {
    //     this.author = author;
    // }

    // constructor, getters and setters
}