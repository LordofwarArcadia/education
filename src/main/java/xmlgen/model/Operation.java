package xmlgen.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operation
{
    private InsAmout InsAmout;

    private String SPName;

    public InsAmout getInsAmout ()
    {
        return InsAmout;
    }

    public void setInsAmout (InsAmout InsAmout)
    {
        this.InsAmout = InsAmout;
    }

    public String getSPName ()
    {
        return SPName;
    }

    public void setSPName (String SPName)
    {
        this.SPName = SPName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [InsAmout = "+InsAmout+", SPName = "+SPName+"]";
    }
}