package com.example.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author whoami
 */
@Order(value = 1)
@Component
public class BeanImlTwo implements BeanInterface{
}
