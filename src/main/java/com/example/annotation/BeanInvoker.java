package com.example.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author whoami
 */
@Component
public class BeanInvoker {

    @Autowired
    private List<BeanInterface> list;
    /** 因为加了Autowire备注，会自动扫描容器中关于BeanInterface的实例，将ID传入到MAP中的String中，对象放入到BeanInterface中 **/
    @Autowired
    private Map<String,BeanInterface> map;

    @Autowired
    @Qualifier("beanImlTwo")
    private BeanInterface beanInterface;


    public void say(){
        System.out.println("List:");
        if(null != list){
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        }
        else{
            System.out.println("List is null!!!!!");}

        System.out.println("\n\nMap:");
        if(null != map && map.size() != 0) {
            for(Map.Entry<String,BeanInterface> entry : map.entrySet()){
                System.out.println(entry.getKey()+"," + entry.getValue().getClass().getName());
            }
        }else{
            System.out.println("Map<String,BeanInterface> map is null");
        }

        System.out.println("\n\n\n"+beanInterface.getClass().getName());
    }
}
