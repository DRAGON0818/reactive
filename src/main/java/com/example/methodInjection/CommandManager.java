package com.example.methodInjection;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author whoami
 * Lookup Method injection 是容器重写容器管理的Bean上的 方法 并返回容器中命名为另一个Bean的查找结果的能力。
 * Spring通过CGLIB库中的字节码动态生成覆盖该方法的子类，从而实现方法注入。
 */
public abstract class CommandManager  {

    public Object process(Object commandState) {
        Command command = createCommand();
        command.setState(commandState);
        return command.execute() ;
    }

    public Object myProcess(Object commandState){
        MyCommand myCommand =createMyCommand();
        myCommand.setState(commandState);
        return myCommand.execute();
    }
    /**  抽象方法返回容器管理的另一个实例Bean **/
    @Lookup
    protected abstract Command createCommand();

    @Lookup
    protected abstract MyCommand createMyCommand();

}
