**Key things**

```yaml


Methods in Flux and Stream.



The content Type is very  important when i am writing Reactive Applications,


It i do not specify my Content Type the application still behaves like a non-reactive
application.


return route().GET("/products",request -> ok().contentType(MediaType.TEXT_EVENT_STREAM).body(productService.getAll(), Product.class)).
build();


```

**Advanatages of Reactive Application**

```yaml


1.You make maximum use of your application thread, Your thread can be working on other requests
as you await the response.

2.You can receive a stream of events instead of waiting for everthing to be processed,This is
a huge advanatage for data intensive applications.

3.Enhances the performance of your application.


It makes use of Cores in your application.


```


**Dependency Injection**

```yaml


1st way


private final ProductService productService;

public RoutesConfig(ProductService productService) {
this.productService = productService;
}

//inside the Body when calling a publisher i should also return the type of Publisher/Type of what i am returning
@Bean
public RouterFunction<ServerResponse> router(){
return route().GET("/products", request -> ok().contentType(MediaType.TEXT_EVENT_STREAM)
.body(productService.getAll(), Product.class)).build();
}


Method Two

You can inject it as a parameter of the second method

Especially if you are using it once,you can inject it just directly,

  @Bean
  public RouterFunction<ServerResponse> router(ProductService productService){
  return route().GET("/products", request -> ok().contentType(MediaType.TEXT_EVENT_STREAM)
  .body(productService.getAll(), Product.class)).build();
}
```

**Refactoring Lambda Expression**

```yaml


 req-> productHandler.getAll(req)
 
 
 To
 
 productHandler::getAll

```


*Note**

```yaml


Never return the request or response in the service class,thet should always be the responsibility
of the Controller,

When using the routerConfig the returning of the request and the response should be done at the handler
Level.


```