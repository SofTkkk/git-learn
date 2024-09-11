package com.it.control;
//导包从包根目录开始导

import com.it.Pojo.*;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//加上RestController就是当前的请求处理类
@RestController

public class m {
    //说明处理的请求地址
//    @RequestMapping("simpleParam")
//    public String ok(HttpServletRequest request) {
//        //获取请求参数,原始方式
//        String name=request.getParameter("name");
//        String age=request.getParameter("age");
//        //类型转换
//        int age1=Integer.parseInt(age);
//        System.out.println(name+"::"+age1);
//
//        System.out.println("ok");
//        return "ok";
    @RequestMapping("simpleParam")
    public String ok(@RequestParam(name = "name", required = false) String username, Integer age) {
        //获取请求参数,基于springboot方式
//        String name=request.getParameter("name");
//        String age=request.getParameter("age");
        //类型转换
//        int age1=Integer.parseInt(age);
        System.out.println(username + "::" + age);

        System.out.println("ok");
        return "ok";

    }


    //2. simple实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "simplePojo";


    }

    //3. 复杂实体参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "complexPojo";


    }

    //4. 数组参数封装, 请求参数名与数组参数名相同且请求参数为多个定义数组类型参数即可接收参数
    @RequestMapping("/ArrPojo")
    public String complexPojo(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "arrayPojo";


    }


    //5. 集合封装 把前端传过来的相同键的不同值封装成集合,保证定义的形参集合名字与键相同
    @RequestMapping("/ListPojo")
    public String complexPojo(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "listPojo";
    }


    @RequestMapping("/datetimeParam")
    public String datetimeParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "ok-datetimeParam";
    }


    //前端传递json数据格式的数据,后端定义实体(Pojo)类型形参接收,json数据封装在了一个实体类对象里面,要求json键名与形参对象属性名相同
    @RequestMapping("/JsonPojo")
    public String JsonParam(@RequestBody User user){
        System.out.println(user);
        return "JsonParam";

    }

    //路径参数同url直接传递参数,前端请求多个形式相同的url,后端用同一种方式处理
    @RequestMapping("/path/{id}/{name}")
    public String PathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        return "pathParam";
    }


    /*@ResponseBody 方法注解类注解
    位置:controller 方法上或类上
    作用: 将方法返回值直接响应如果返回类型是实体类/对象/集;合,将会自动转为json格式响应
    说明: @RestController=@controller+@ResponseBody
    */
    @RequestMapping("hello yet")
    public Result hello(){
//        return new Result(1,"success","hello world~ ");
          return Result.success("hello world yet");
    }

    @RequestMapping("/addr")
    public Result addr(){
        Address address = new Address();
        address.setProvince("江西");
        address.setCity("上饶");
        return Result.success(address);
    }



}
