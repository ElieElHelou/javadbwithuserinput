public class Info {
    private String logusername = "";
    private String logpassword = "";
    private String regusername = "";
    private String regpassword = "";
    private String regemail = "";

    public void setRegemail(String email){
        this.regemail = email;
    }

    public void setRegpassword (String pass){
        this.regpassword = pass;
    }

    public void setRegusername (String username){
        this.regusername = username;
    }

    public void setLogusername (String username){
        this.logusername = username;
    }

    public void setLogpassword (String pass){
        this.logpassword = pass;
    }

    public String getRegemail (){
        return this.regemail;
    }

    public String getRegusername (){
        return this.regusername;
    }

    public String getRegpassword (){
        return this.regpassword;
    }

    public String getLogusername (){
        return this.logusername;
    }

    public String getLogpassword (){
        return this.logpassword;
    }
}
