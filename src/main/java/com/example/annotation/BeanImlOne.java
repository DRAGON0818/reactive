package com.example.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author whoami
 * Order 对于List对象，是有效的，对于Map是无效的。
 */
@Order(value = 2)
@Component
public class BeanImlOne implements BeanInterface{
}
