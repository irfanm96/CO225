import java.util.HashMap;
import java.util.Map;

abstract class ACESmember {

    private  String name;
    private  String membershipType;
    private  boolean allowedToHoldPosition;
    private  static HashMap<String ,ACESmember> list=new HashMap<String, ACESmember>();

    public ACESmember(String name , String membershipType){
        this.name=name;
        this.membershipType=membershipType;
        this.allowedToHoldPosition=true;
        list.put(name,this);
    }

    public String getName(){
        return this.name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean canBeSeniorTreseurer(){
        return this.membershipType.equals("non-student");
    }

    public boolean canHoldPosition(){
        return this.allowedToHoldPosition;
    }

    public boolean setAllowedToHoldPosition(ACESmember s,boolean value ){
        if(this.canBeSeniorTreseurer()){
            s.allowedToHoldPosition=value;
            return  true;
        }
        return  false;
    }

    public static void showEligable(){

        for (Map.Entry<String,ACESmember> i: list.entrySet()){
            if(i.getValue().allowedToHoldPosition) {
                System.out.println(i.getKey());
            }
        }
    }


}

class  ACESstudent extends  ACESmember {

    private  String  regNo;

    public ACESstudent (String name, String regNo){
        super(name,"student");
        this.regNo=regNo;
    }

}
class  ACESNonStudent extends  ACESmember {

    public ACESNonStudent (String name){
        super(name,"non-student");
    }

    public ACESNonStudent (ACESstudent s){
        super(s.getName(),"non-student");
    }

    public void markAsRadical (ACESmember s ){
        this.setAllowedToHoldPosition(s,false);
    }

}
