package automation.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("ValCurs")
public class ValCurs {

    @XStreamAlias("Date")
    @XStreamAsAttribute
    private String date;

    @XStreamAlias("name")
    @XStreamAsAttribute
    private String name;

    private List<Valute> valutes = new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

}
