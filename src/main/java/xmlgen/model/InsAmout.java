package xmlgen.model;

public class InsAmout
{
    private TotalAmount TotalAmount;

    public TotalAmount getTotalAmount ()
    {
        return TotalAmount;
    }

    public void setTotalAmount (TotalAmount TotalAmount)
    {
        this.TotalAmount = TotalAmount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TotalAmount = "+TotalAmount+"]";
    }
}
	