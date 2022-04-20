package gebd.progetto;

import java.io.Serializable;
public class GFArchi implements Serializable{
    //private int src;
    //private int dst;
    private String src;
    private String dst;
    public GFArchi() {
    }

    //public GFArchi(int src, int dst)
    public GFArchi(String src, String dst)
    {
        super();
        this.src = src;        
        this.dst = dst;
    }

    //public int getSrc()
    public String getSrc()
    {
        return src;
    }
    
    //public void setSrc(int src)
    public void setSrc(String src)
    {
        this.src = src;
    }
    //public int getdst()
    public String getdst ()
    {
        return dst;
    }
    
    //public void setdst(int dst)
    public void setdst (String dst)
    {
        this.dst = dst;
    }
}