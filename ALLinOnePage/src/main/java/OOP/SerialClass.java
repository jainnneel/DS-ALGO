package OOP;

import java.io.Serializable;

public class SerialClass implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9013880350564732020L;
    private String name;
    private String fname;
    private String fname1;
    
    public SerialClass() {
        super();
        // TODO Auto-generated constructor stub
    }
    public SerialClass(String name, String fname) {
        super();
        this.name = name;
        this.fname = fname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    @Override
    public String toString() {
        return "SerialClass [name=" + name + ", fname=" + fname + "]";
    }
    
    
    
}
