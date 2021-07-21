## Spring  IOC容器的创建流程

- ```java
  // 创建一个容器  =====>调用refresh()方法
  new ClassPathXmlApplicationContext("config.xml");
  
  //AbstractApplicationContext
   public void refresh() throws BeansException, IllegalStateException {
          synchronized(this.startupShutdownMonitor) {
              StartupStep contextRefresh = this.applicationStartup.start("spring.context.refresh");
              this.prepareRefresh();//预处理  清理缓存，记录时间和状态等
              ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();
              this.prepareBeanFactory(beanFactory);//为IOC容器BeanFactory注册，初始化和排除一些固定的处理器
  
              try {
                  this.postProcessBeanFactory(beanFactory);//为所有容器设置后置处理器
                  StartupStep beanPostProcess = this.applicationStartup.start("spring.context.beans.post-process");
                  this.invokeBeanFactoryPostProcessors(beanFactory);//反射调用处理器方法
                  this.registerBeanPostProcessors(beanFactory);
                  beanPostProcess.end();
                  this.initMessageSource();
                  this.initApplicationEventMulticaster();
                  this.onRefresh();
                  this.registerListeners();
                  this.finishBeanFactoryInitialization(beanFactory);
                  this.finishRefresh();
              } catch (BeansException var10) {
                  if (this.logger.isWarnEnabled()) {
                      this.logger.warn("Exception encountered during context initialization - cancelling refresh attempt: " + var10);
                  }
  
                  this.destroyBeans();
                  this.cancelRefresh(var10);
                  throw var10;
              } finally {
                  this.resetCommonCaches();
                  contextRefresh.end();
              }
  
          }
      }
  ```

- this.prepareRefresh();//刷新前预处理

  - ```java
    this.initPropertySources();//初始化属性设置
    ```

  - ```java
    this.getEnvironment().validateRequiredProperties();//校验属性是否设置合法
    ```

  - ```java
    this.earlyApplicationEvents = new LinkedHashSet();//保存容器中早期事件 后续结合事件派发器派发事件
    ```

- ```java
  ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();//获取BeanFactory工厂
  ```

  - ```java
    protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
        this.refreshBeanFactory();//刷新创建BeanFactory工厂，创建一个BeanFactory，设置序列化ID
        return this.getBeanFactory();//返回一个GenericApplicationContext Bean工厂
    }
    ```

  - 获得一个`ConfigurableListableBeanFactory`BeanFactory工厂

  - ```java
    this.prepareBeanFactory(beanFactory);//对BeanFactory预准备工作。
    
     protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
            beanFactory.setBeanClassLoader(this.getClassLoader());//设置类加载器
            if (!shouldIgnoreSpel) {
                beanFactory.setBeanExpressionResolver(new StandardBeanExpressionResolver(beanFactory.getBeanClassLoader()));//设置表达式解析器
            }
    
            beanFactory.addPropertyEditorRegistrar(new ResourceEditorRegistrar(this, this.getEnvironment()));
            beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));//添加部分后置处理器
            beanFactory.ignoreDependencyInterface(EnvironmentAware.class);
            beanFactory.ignoreDependencyInterface(EmbeddedValueResolverAware.class);
            beanFactory.ignoreDependencyInterface(ResourceLoaderAware.class);
            beanFactory.ignoreDependencyInterface(ApplicationEventPublisherAware.class);
            beanFactory.ignoreDependencyInterface(MessageSourceAware.class);
            beanFactory.ignoreDependencyInterface(ApplicationContextAware.class);
            beanFactory.ignoreDependencyInterface(ApplicationStartup.class);
           // 设置可以自动装配的解析器依赖
       			beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
            beanFactory.registerResolvableDependency(ResourceLoader.class, this);
            beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);
            beanFactory.registerResolvableDependency(ApplicationContext.class, this);
            // 添加部分后置处理器
       			beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(this));
            if (!NativeDetector.inNativeImage() && beanFactory.containsBean("loadTimeWeaver")) {
                beanFactory.addBeanPostProcessor(new LoadTimeWeaverAwareProcessor(beanFactory));
                beanFactory.setTempClassLoader(new ContextTypeMatchClassLoader(beanFactory.getBeanClassLoader()));
            }
    				//给BeanFactory注册一些组件
            if (!beanFactory.containsLocalBean("environment")) {
                beanFactory.registerSingleton("environment", this.getEnvironment());
            }
    
            if (!beanFactory.containsLocalBean("systemProperties")) {
                beanFactory.registerSingleton("systemProperties", this.getEnvironment().getSystemProperties());
            }
    
            if (!beanFactory.containsLocalBean("systemEnvironment")) {
                beanFactory.registerSingleton("systemEnvironment", this.getEnvironment().getSystemEnvironment());
            }
    
            if (!beanFactory.containsLocalBean("applicationStartup")) {
                beanFactory.registerSingleton("applicationStartup", this.getApplicationStartup());
            }
    
        }
    ```

- ```java
  this.postProcessBeanFactory(beanFactory);//准备工作完成后进行的后置处理工作
  ```





**以上是BeanFactory创建预准备工作**

---------------

- ```
  this.invokeBeanFactoryPostProcessors(beanFactory);//执行BeanFactoryPostProcessor的方法
  //有两个接口，BeanFactoryPostProcessor，BeanDefinitionRegistryPostProcessor
  this.registerBeanPostProcessors(beanFactory);
  
  	1. 先判断是否是BeanDefinitionRegistryPostProcessor，在执行BeanFactoryPostProcessor后置处理器。
  	2.执行后置处理器的过程：	
  		1.先执行实现了优先级排序的
  		2.再执行有Order注释的
  		3.最后执行普通的后置处理器
  ```





- ```java
  this.registerBeanPostProcessors(beanFactory);//为Bean注册后置处理器【拦截Bean的创建过程】
  先注册有优先级的，在注册Order接口的，最后是其他普通的后置处理器，添加到容器中。
  ```





 - ```java
   this.initMessageSource();//注册组件，做国际化，消息绑定等工作
   this.initApplicationEventMulticaster();//初始化事件派发器，添加到容器中
   	// 先获得BeanFactory
   	/**
   	* 在容器中获得applicationEventMulticaster派发起
   	* 如果没有，就创建一个，注入到组件中
   	**//
   
   this.onRefresh();//子类重写，重启刷新
   ```

- ```java
  this.registerListeners(); // 获得容器中所有实现了ApplicationListrener的组件，注册到容器中
  //早期保存的时间，通过事件派发器 派发
  ```

- ```java
  this.finishBeanFactoryInitialization(beanFactory);//初始化 所有剩下的单实例Bean
  // 获取容器中所有的Bean，获得Bean的定义信息 RootBeanDefinition
  // 如果Bean不是抽象，是单实例，不是懒加载
  // 判断是否是FactoryBean接口，是的话，通过FactoryBean的getObject方法
  // 如果不是FactoryBean  
  // 直接调用getBean方法====》doGetBean===》getSinglethon（BeanName）
  // 如果能够从缓存中获取，直接获得，没有的话
  // 缓存中 拿不到，开始Bean的创建流程  先获得BeanFactory对象
  	// 标记Bean已经被标记《排除多线程影响》
  	// 获得BeanDefinition信息
    // 获得当前Bean依赖的其他的Bean的信息，如果有 通过getBean获得依赖的Bean
  	// 启动单实例Bean的创建方法
    // 		1.createBean(beanName,mdb,args);
  	//    2.先判断是否有【InstantiationAwareBeanPostProcess】执行器
  	//     如果有的话，返回代理对象。
  	//    3. 如果返回为空，就调用【doCreateBean(beanName,mdbToUser,args)】创建对象
  							// 利用工厂方法或者构造器创建Bean实例-----》放到容器中
  							// 执行MergeBeanDefinitionPostProcessor后置处理器
  							// populateBean() 通过反射为bean属性赋值
  									// 后置处理器
  									//applyPropertyValues 通过反射为Bean的属性赋值
  	//    4.初始化Bean initializeBean(beanName，exposeObject,mbd);
  					// invokeAwareMethod(beanName,bean)  执行Aware接口的方法
  					// 执行所有的后置处理器的postProcessBeforeInitialization()方法
  				  // 初始化的方法执行  【4中方式定义初始化方法】
            // 之后所有后置处理的 postProcessAfterInitialization()方法
  	//    5.单例Bean注册Bean的销毁方法，并返回Bean实例。
  	//  将创建的单例Bean添加到缓存中，singlethonObjects
    //  【IOC容器就是Map  ，  Map存储bean，以及定义信息，环境信息等】
  
  
  //  所有的Bean创建完成后，检查Bean是否是SmartInitializingSinglethon接口
  // this.finishRefresh();完成BeanFactory的初始化创建工作，IOC容器完成创建
  
  ```

  ---



=== 总结===

1、Spring容器启动的时候，保存所有注册的Bean的定义信息

​	【xml注册】【注解注册】

2、Spring容器会在合适的时机创建这些Bean

​	1、用到这个bean的时候，getBean

​	2、统一创建剩下所有单实例bean的时候，finishBeanFactoryInitialization

3、后置处理器：每一个Bean创建完成后，都会使用各种后置处理器处理，增强bean的功能。

4、事件驱动类型：

​	ApplicationListener 时间监听器

​	ApplicationEventcaster 事件派发器

-----



【Spring循环依赖和三级缓存解决方案】

​	Spring在创建对象Bean的生命周期流程中，会先创建一个bean实例，在通过反射注入属性，最后是初始化方法【其中包括初始化方法的前后的方法，和后置处理器等】。

**问题：A依赖B，B依赖A  如何创建？？？**

A:spring通过singletonObjects，earlySingletonObjects，singletonFactories三级缓存解决。

![image-20210629151954928](/Users/whoami/Library/Application Support/typora-user-images/image-20210629151954928.png)

`一级缓存就是IOC容器，用于存放容器中所有实例化和初始化完成的bean实例`

`三级缓存用于存放因为依赖问题，无法设置属性和初始化的半成品Bean`

`二级缓存是用于判断bean对象是否被AOP代理，因为是代理对象，所以每次获取的对象都不是同一个，但是我们创建的是单例，为了确保能够获得同一个实例，从二级缓存中获取`

