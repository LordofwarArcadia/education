package xmlgen.model;

public class TotalAmount
{
    private String InsAmoutValue;

    public String getInsAmoutValue ()
    {
        return InsAmoutValue;
    }

    public void setInsAmoutValue (String InsAmoutValue)
    {
        this.InsAmoutValue = InsAmoutValue;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [InsAmoutValue = "+InsAmoutValue+"]";
    }
}
	