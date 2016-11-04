#MVP demo

A simple MVP demo.  

Uses RXJava for network calls  

Uses Dagger 2 for dependency injection  

##**PLEASE NOTE**
The demo comes in two product flavours: "prod" and "mock".  
To run the application please select the "prod" flavour.   
To run the instrumented tests please select the "mock" flavour, it injects a mock api dependency.    

##Technical considerations

###Tests
JUnit and Instrumented (Espresso) tests are present in the respective source folders.  
Tests use Mockito for mocking, verifying and captors.  
Coverage is 19% of classes, 10% of lines. More tests need to be written.  

###Architectural approach
A simple implementation of the MPV pattern is applied.   
The Presenters subscribe to the Model via Observers (_RxAndroid_) to receive the data. They subscribe in `onResume()` and unscubscribe in `onPause()` to avoid leaks. The requests to the api are cached using the `Observable.cache()` operator.  
The requests are retried in case InterruptedIOException.  
We need to store the cached requests themselves so that they survive config changes, otherwise there would be no benefit in caching. 
I decided to use Singletons and inject them in the Model using Dagger. 
I am aware this approach is debatable, other solutions are possible: 
use a Service (started service to outlive the Activity config changes, bound to allow communication), use a retained Fragment, store 
them in the Application. In any case `Observable` is not `Serializable` nor `Parcelable` therefore use `Activity.onSaveInstanceState(Bundle)` is not an option.


The app uses one Activity and two Fragments.   

###Retry logic

Here we transform a series of Observables that emit a Throwable into one Observable (hence flattened) that emits a series of either onComplete() or onError().    

        Api.getAllFilms().retryWhen(exceptions -> exceptions.flatMap(exception -> {
            if (exception instanceof InterruptedIOException) {
                return Observable.just(null);
            }
            return Observable.error(exception);
        }));
We retry only in case of InterruptedIOException.  

retryWhen Javadoc: http://reactivex.io/RxJava/javadoc/rx/Observable.html#retryWhen(rx.functions.Func1)