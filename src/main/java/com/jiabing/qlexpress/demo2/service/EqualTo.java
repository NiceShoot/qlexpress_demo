package com.jiabing.qlexpress.demo2.service;

import com.ql.util.express.Operator;
import com.ql.util.express.exception.QLException;

/**
 * @author jiabing
 */
public class EqualTo extends Operator {

    public EqualTo() {
    }

    public EqualTo(String name) {
        this.name = name;
    }
    public EqualTo(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        if (list.length != 2 ){
            throw new QLException("操作数异常数");
        }
        return list[0] == list[1];
    }
}
