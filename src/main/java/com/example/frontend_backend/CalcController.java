package com.example.frontend_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CalcController {
    @GetMapping("/calc/add/{n1}/{n2}")
    public String add(@PathVariable int n1, @PathVariable int n2){
        int sum=n1+n2;
        return "Addition: "+sum;
    }
    @GetMapping("/calc/log10/{n1}")
    public String log10(@PathVariable double n1){
        double res=Math.log10(n1);
        return String.format("Log to the base 10 value: %.2f",res);
    }
    @GetMapping("/calc/log2/{n1}")
    public String log2(@PathVariable double n1){
        double r=Math.log(n1);
        return String.format("Log to the base 2 value: %.2f",r);
    }
    @GetMapping("/calc/tan/{n}")
    public String tan(@PathVariable double n){
        double r=Math.tan(n);
        return String.format("Tan value: %.2f",r);
    }
    @GetMapping("/calc/sin/{n}")
    public String sin(@PathVariable double n){
        double r=Math.sin(n);
        return String.format("Sin value: %.2f",r);
    }
    @GetMapping("/calc/cos/{n}")
    public String cos(@PathVariable double n){
        double r=Math.cos(n);
        return String.format("Cos value: %.2f",r);
    }
    @GetMapping("/spiral_matrix_printing")
    public List<Integer> sm(){
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> lst=new ArrayList<>();
        int top=0;
        int left=0;
        int right=mat[0].length-1;
        int bottom=mat.length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                lst.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                lst.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    lst.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    lst.add(mat[i][left]);
                }
                left++;
            }
        }
        return lst;
    }
}
@RestController
class Json_return_type{
    @GetMapping("/cal/add/{a}/{b}")
    public Map<String,Object> addition(@PathVariable int a,@PathVariable int b){
        return Map.of("operation","addition","result",a+b);
    }
}
