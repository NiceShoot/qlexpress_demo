package com.jiabing.qlexpress.demo2.service;

import com.ql.util.express.Operator;
import com.ql.util.express.exception.QLException;

/**
 * @author jiabing
 */
public class IsHumanOrNot extends Operator {

    public IsHumanOrNot() {
    }

    public IsHumanOrNot(String name) {
        this.name = name;
    }
    public IsHumanOrNot(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        if (list.length != 1 ){
            throw new QLException("操作数异常,有且只能有一个操作数");
        }
        Object o = list[0];
        return Integer.parseInt(o.toString())==10?"是":"不是";
    }
}
