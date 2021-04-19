package application;
import entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String path = "/home/bruno/Documentos/Projetos do Curso Java/expressao_lambda/in.csv";

        System.out.print("Enter Salary: ");
        Double salary = sc.nextDouble();



        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();
            String line = br.readLine();


            while(line != null){
                String[] filds = line.split(",");
                list.add(new Employee(filds[0],filds[1],Double.parseDouble(filds[2])));
                line = br.readLine();
            }

            List<String> emp = list.stream().filter(p-> p.getSalary()>salary).map(p->p.getEmail()).sorted().collect(Collectors.toList());
            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
            emp.forEach(System.out::println);


            double sum = list.stream().filter(x -> x.getName().charAt(0) == 'M').map(x -> x.getSalary()).reduce(0.0, (x, y) -> x + y);


            System.out.printf("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",sum));

        }

        catch (IOException e){
            System.out.printf("Error : " + e);
        }










        sc.close();







    }




}
