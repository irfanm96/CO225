import java.util.ArrayList;
import java.util.Iterator;

abstract class Project {

    private String name;
    private double cost;
    private boolean approved;
    public  static  double limit=1000000;
    private static ArrayList<Project> list = new ArrayList<Project>();

    public Project(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.list.add(this);
    }

    public void  approve(boolean status){
        this.approved=status;
    }

    public  void show(){
        System.out.println(this.name +" approved status: " +this.approved);
    }

    public final static void showProjects(){

        Iterator itr=list.iterator();
        Project e;
        while(itr.hasNext()){
            e=(Project)itr.next();
            e.show();
        }
    }

}


class  StudentProject extends  Project{

    private  String stdBody;
    public StudentProject(String name, String stdBody , double cost){
        super(name,cost);
        this.stdBody=stdBody;
        if(cost<limit){
            this.approve(true);
        }
    }

    @Override
    public void approve(boolean status ) {
        super.approve(status);
    }
}

class  DepartmentProject extends  Project{

    public DepartmentProject(String name, double cost){
        super(name,cost);
        this.approve(true);

    }

    @Override
    public void approve(boolean status) {
        super.approve(status);
    }


}
