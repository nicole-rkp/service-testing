package automation.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Valute")
public class Valute {
    @XStreamAlias("ID")
    @XStreamAsAttribute
    private Integer id;

    @XStreamAlias("NumCode")
    @XStreamAsAttribute
    private String numCode;

    @XStreamAlias("CharCode")
    @XStreamAsAttribute
    private String CharCode;

    @XStreamAlias("Nominal")
    @XStreamAsAttribute
    private Integer Nominal;

    @XStreamAlias("Name")
    @XStreamAsAttribute
    private String Name;

    @XStreamAlias("Value")
    @XStreamAsAttribute
    private Double Value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        this.CharCode = charCode;
    }

    public Integer getNominal() {
        return Nominal;
    }

    public void setNominal(Integer nominal) {
        Nominal = nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }



}
