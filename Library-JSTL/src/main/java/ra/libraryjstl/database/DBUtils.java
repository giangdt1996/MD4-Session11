package ra.libraryjstl.database;

import ra.libraryjstl.model.Dept;
import ra.libraryjstl.model.Emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DBUtils {
    private static final List<Dept> DEPARTMENTS=new ArrayList<Dept>();
    static{
        initData();
    }
    private static void initData() {
        Dept accountingDept = new Dept(10, "ACCOUNTING", "NEW YORK");
        accountingDept.addEmployee(new Emp(7782, "CLARK", "MANAGER", "6/9/1981", 2450.00f));
        accountingDept.addEmployee(new Emp(7839, "KING", "PRESIDENT", "11/17/1981", 5000.00f));
        accountingDept.addEmployee(new Emp(7934, "MILLER", "CLERK", "6/9/1981", 1300.00f));

        //
        Dept researchDept = new Dept(20, "RESEARCH", "DALLAS");
        researchDept.addEmployee(new Emp(7369, "SMITH", "CLERK", "12/17/1980", 800.00f));
        researchDept.addEmployee(new Emp(7788, "SCOTT", "ANALYST", "4/19/1987", 3000.00f));
        researchDept.addEmployee(new Emp(7876, "ADAMS", "CLERK", "2/7/1987", 1100.00f));
        researchDept.addEmployee(new Emp(7878, "FORD", "ANALYST", "12/3/1981", 3000.00f));
        researchDept.addEmployee(new Emp(7369, "JONES", "MANAGER", "4/2/1981", 2975.00f));
        //
        //
        Dept salesDept = new Dept(30, "SALES", "CHICAGO");
        salesDept.addEmployee(new Emp(7654, "MARTIN", "SALSESMAN", "9/28/1981", 1250.00f));
        salesDept.addEmployee(new Emp(7499, "ALLEN", "SALSESMAN", "2/20/1981", 1600.00f));
        salesDept.addEmployee(new Emp(7521, "WARD", "SALSESMAN", "2/22/1981", 1250.00f));
        salesDept.addEmployee(new Emp(7844, "TUNER", "SALSESMAN", "9/8/1981", 1500.00f));
        salesDept.addEmployee(new Emp(7900, "JAMES", "CLERK", "12/3/1981", 950.00f));
        //
        Dept openrationsDept = new Dept(40, "OPERATIONS", "BOSTON");
        //
        DEPARTMENTS.add(accountingDept);
        DEPARTMENTS.add(researchDept);
        DEPARTMENTS.add(salesDept);
        DEPARTMENTS.add(openrationsDept);
    }
        //Truy van bang Department
        public static List<Dept> queryDepartments(){
            return DEPARTMENTS;
        }

        //Truy van bang Employee.
       //Lay danh sach cac nhan vien cua 1 phong ban
    public static Set<Emp> queryEmployees(int deptNo){
        for(Dept dept: DEPARTMENTS){
            if(deptNo == dept.getDeptNo()){
                return dept.getEmployees();
            }
        }
        return null;
    }
    }

