package app;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
/**
 * Actionable
 */
public class Actionable {

    public boolean isNullOrEmpty(String s) {
        s=s.replaceAll("\\s","");
        if(s != null && !s.isEmpty())
        {
            return true;
        } else{
            return false;
        }
        
    }

    public int CheckIDExits(Student[] student, String ID, int n)
    {
        int result=-1;
        if(n >0)
        {
            for(int i=0; i <n;i++)
            {
                if(ID.equalsIgnoreCase(student[i].getID()))
                {
                    result=i;
                    break;
                }
            }
        }
        return result;
    }

    private  Pattern patternID=Pattern.compile("^[G][TC]{1}[0-9]{5,}");
    public boolean checkIDStudent(String s)
    {
        if(isNullOrEmpty(s)==false)
        {
            return false;
        }
        return patternID.matcher(s).matches();
    }

    private  Pattern patternIDLec=Pattern.compile("^[0-9]{8}");
    public boolean checkIDLecturer(String s)
    {
        if(isNullOrEmpty(s)==false)
        {
            return false;
        }
        return patternIDLec.matcher(s).matches();
    }

    private  Pattern patternName=Pattern.compile("^[a-zA-Z. ]+$");
    public boolean checkName(String s)
    {
        if(isNullOrEmpty(s)==false)
        {
            return false;
        }
        return patternName.matcher(s).matches();
    }

    private  Pattern patternAddress=Pattern.compile("^[a-zA-Z0-9 .-]+$");
    public boolean checkAddress(String s)
    {
        if(isNullOrEmpty(s)==false)
        {
            return false;
        }
        return patternAddress.matcher(s).matches();
    }

    private  Pattern patternEmail=Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    public boolean checkEmail(String email)
    {
        if(isNullOrEmpty(email)==false)
        {
            return false;
        }
        return patternEmail.matcher(email).matches();

    }

    public boolean checker_(Student temponary)
    {
        if(checkIDStudent(temponary.getID()) && checkName(temponary.getName()) && checkEmail(temponary.getEmail()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private  Pattern patternNum=Pattern.compile("-?\\d+(\\.\\d+)?");
    public boolean checkNum(String s)
    {
        
        if(isNullOrEmpty(s)==false)
        {
            return false;
        }
        return patternNum.matcher(s).matches();
    }


    
    public boolean CheckAnswer(String reply) {
        if (isNullOrEmpty(reply)==false) {
            return false;
        } else {
            if (reply.equalsIgnoreCase("yes") || reply.equalsIgnoreCase("no")) {
                return true;
            } else {
                return false;
            }
        }
        
        
    }


    public boolean checkDate(String s)
    {
        if (isNullOrEmpty(s)==false) {
            return false;
        }
        else
        {
            SimpleDateFormat strDate=new SimpleDateFormat("dd/MM/yyy");
            strDate.setLenient(false);
            try {
                Date dateFinal=strDate.parse(s);
                return true;
            } catch (Exception e) {
                //TODO: handle exception
                return false;
            }
        }
    }
}