package com.jiabing.qlexpress.demo2;

import com.jiabing.qlexpress.demo2.service.EqualTo;
import com.jiabing.qlexpress.demo2.service.IsHumanOrNot;
import com.jiabing.qlexpress.demo2.service.VipLessonService;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DemoMain {


    public static void main(String[] args)throws Exception {

        demo4();
    }

    private static void demo4() throws Exception {
        ExpressRunner runner = new ExpressRunner();

        runner.addOperator("等于",new EqualTo("=="));
        runner.addOperatorWithAlias("电视","and",null);

        runner.addFunctionOfServiceMethod("是小明吗",new VipLessonService(),"isXiaoMing",new Class[]{String.class},null);

        runner.addFunction("是个人吗",new IsHumanOrNot());
        runner.addClassMethod("是人吗",Integer.class,new IsHumanOrNot());

        DefaultContext<String,Object> context = new DefaultContext<String,Object> ();
        context.put("小明",10);
        context.put("小黑",10);
        context.put("小红",20);
        context.put("文案","123");
        context.put("名字","小明");

        List<String> errorList = new ArrayList<>();

        String expressStr = "是个人吗(小明)";
        Object execute = runner.execute(expressStr, context, errorList, false, true);
        System.out.println(execute);
    }


    private static void demo3() throws Exception {
        ExpressRunner runner = new ExpressRunner();

        runner.addOperator("等于",new EqualTo("=="));

        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs", new String[] {"double"}, null);
        runner.addFunctionOfClassMethod("是空的吗", StringUtils.class.getName(), "isEmpty", new String[]{"Object"}, null);

        runner.addFunctionOfServiceMethod("是小明吗",new VipLessonService(),"isXiaoMing",new Class[]{String.class},null);

        runner.addFunction("是个人吗",new IsHumanOrNot());
        runner.addClassMethod("是人吗",Integer.class,new IsHumanOrNot());

        DefaultContext<String,Object> context = new DefaultContext<String,Object> ();
        context.put("小明",10);
        context.put("小黑",10);
        context.put("小红",20);
        context.put("文案","123");
        context.put("名字","小明");

        List<String> errorList = new ArrayList<>();
        //String expressStr = "(小明-小黑) 等于 小红";
        //String expressStr = "是个人吗(小明)";
        //String expressStr = "是空的吗(文案)";
        //String expressStr = "是小明吗(名字)";
        String expressStr = "小明.是人吗()";
        Object execute = runner.execute(expressStr, context, errorList, false, true);
        System.out.println(execute);
    }


    private static void demo1() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("而且","and",null);
        runner.addOperatorWithAlias("如果", "if",null);
        runner.addOperatorWithAlias("则", "then",null);
        runner.addOperatorWithAlias("否则", "else",null);

        DefaultContext<String,Object> context = new DefaultContext<String,Object> ();
        context.put("语文",10);
        context.put("数学",20);
        context.put("英语",30);
        List<String> errorList = new ArrayList<>();
        String expressStr = "如果(语文+数学+英语>270)则{return 1;}否则{return 0;}";
        Object execute = runner.execute(expressStr, context, errorList, false, true);
        System.out.println(execute);
        System.out.println(errorList);
    }

    private static void demo2() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionOfServiceMethod("判断1",new VipLessonService(),"isYuWen",new Class[]{Long.class},null);
        runner.addFunctionOfServiceMethod("判断2",new VipLessonService(),"isShuXue",new Class[]{Long.class},null);
        runner.addFunctionOfServiceMethod("判断3",new VipLessonService(),"isYingYu",new Class[]{Long.class},null);
        runner.addFunctionOfServiceMethod("判断4",new VipLessonService(),"isWuLi",new Class[]{Long.class},null);

        runner.addOperatorWithAlias("如果", "if",null);
        runner.addOperatorWithAlias("而且","and",null);
        runner.addOperatorWithAlias("或者","or",null);
        runner.addOperatorWithAlias("则", "then",null);
        runner.addOperatorWithAlias("否则", "else",null);

        DefaultContext<String,Object> context = new DefaultContext<String,Object> ();
        context.put("a",10);
        context.put("b",10);
        context.put("c",10);
        context.put("d",1);

        List<String> errorList = new ArrayList<>();
//        String expressStr = "如果((判断1(a) 而且 判断2(b) 而且 判断3(c)) 或者 判断4(d)) 则 {return 1;} 否则{return 0;}";

        String expressStr = "如果(1+2+3>270)则{return 1;}否则{return 0;}";
        Object execute = runner.execute(expressStr, null, errorList, false, false);
        System.out.println(execute);
        System.out.println(errorList);
    }
}
