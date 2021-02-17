#### cloud-config-center-3344：全局配置中心，实时从githup中读取配置信息，还支持BUS总线+Rabbit同步消息给3355，3366，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-config-center-3355：配置中心，支持手动刷新从3344中读取配置信息，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-config-center-3366：配置中心，支持手动刷新从3344中读取配置信息，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-consumer-feign-hystrix-order80：OpenFeign实现调用方，Eureka实现注册中心，Hystrix实现降级与熔断，调用：
  ###### cloud-provider-hystrix-payment8001

#### cloud-consumer-feign-order80：OpenFeign实现调用方，Eureka实现注册中心，调用：
  ###### cloud-provider-payment8001
  ###### cloud-provider-payment8002

#### cloud-consumer-hystrix-dashboard9001：Hystrix提供的监控平台，不需要注册到注册中心

#### cloud-consumer-order80：RestTemplate实现调用方，Eureka实现注册中心，调用：
  ###### cloud-provider-payment8001
  ###### cloud-provider-payment8001

#### cloud-consumerconsul-order80：RestTemplate实现调用方，Consul实现注册中心，调用：
  ###### cloud-provider-payment8006

#### cloud-consumerzk-order80：RestTemplate实现调用方，Zookeeper实现注册中心，调用：
  ###### cloud-provider-payment8004

#### cloud-eureka-server7001：Eureka注册中心

#### cloud-eureka-server7002：Eureka注册中心

#### cloud-gateway-gateway9527：网关，注册到Eureka的网关服务，路由过滤配置了：
  ###### cloud-provider-payment8001
  ###### cloud-provider-payment8002

#### cloud-provider-demo8080：springboot+mybatis基本模板

#### cloud-provider-hystrix-payment8001：注册到Eureka的提供Hystrix降级熔断的服务提供方，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-provider-payment8001：注册到Eureka的服务提供方，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-provider-payment8002：注册到Eureka的服务提供方，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-provider-payment8004：注册到Zookeeper的服务提供方

#### cloud-provider-payment8006：注册到Consul的服务提供方

#### cloud-stream-rabbitmq-consumer8802：消息接收方，监控从RabbitMQ获取消息，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-stream-rabbitmq-consumer8803：消息接收方，监控从RabbitMQ获取消息，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloud-stream-rabbitmq-provider8801：消息发送方，将消息发送到RabbitMQ，注册到：
  ###### cloud-eureka-server7001
  ###### cloud-eureka-server7002

#### cloudalibaba-config-nacos-client3377：读取Nacos配置文件信息，注册到Nacos:8848

#### cloudalibaba-consumer-nacos-order83：服务调用者，注册到Nacos:8848，调用：
  ###### cloudalibaba-provider-payment9001
  ###### cloudalibaba-provider-payment9002

#### cloudalibaba-provider-payment9001：服务提供方，注册到Nacos:8848，给83调用

#### cloudalibaba-provider-payment9002：服务提供方，通过Nginx注册到Nacos集群，给83调用

#### cloudalibaba-sentinel-service8401：注册进Nacos集群，配置到Sentinel平台，测试限流，熔断，降级

#### cloudalibaba-account-service2003：注册到Nacos集群，给2001调用，测试Seata分布式事务

#### cloudalibaba-order-service2001：注册到Nacos集群，调用2002,2003，测试Seata分布式事务

#### cloudalibaba-storage-service2002：注册到Nacos集群，给2001调用，测试Seata分布式事务


#### 遗留问题：
  ###### Seata版本升级问题
  ###### Nacos配置的Sentinel规则需要Service重启才能同步到Sentinel吗