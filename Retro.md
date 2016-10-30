###**Please note**
The demo comes in two product flavours: "prod" and "mock".
To run the application please select the "prod" flavour. 
To run the instrumented tests please select the "mock" flavour, it injects a mock api dependency.  

##Technical considerations

###Tests
JUnit and Instrumented (Espresso) tests are present in the respective source folders.
Tests use Mockito for mocking, verifying and captors.
Coverage is 19% of classes, 10% of lines. 
More tests need to be written.

###Architectural approach
A simple implementation of the MPV pattern is applied. 
The Presenters subscribe to the Model via Observers (_RxAndroid_) to receive the data.They subscribe in `onResume()` and unscubscribe in `onPause()` to avoid leaks.The requests to the StarWars api are cached using the `Observable.cache()` operator.
The requests are retried in case InterruptedIOException.
We need to store the cached requests themselves so that they survive config changes, otherwise there would be no benefit in caching. 
I decided to store them in the Application class. I am aware this approach can be discussed, other solutions are possible: 
use a Service (started service to outlive the Activity config changes, bound to allow communication), use a retained Fragment, store 
them in a Singleton (but the `Observable` cannot be stored in the `Bundle`).

Dependencies are injected using Dagger 2.

The app use one Activity and two Fragments. 

###Drawbacks and pitfalls
- The Application class, were the requests are stored, might be destroyed in some cases.


##Product considerations

###Assumptions
I assumed I could merge the two stories in one deliverable, a single demo, for convenience, and used a `BottomNavigationView`
for switching the `Fragments`. This would need to be discussed if appropriate for the case.
###To the product manager
The first question would be: which are the key info to show in the list, because I made some assumptions 
about what to show (I do not show the film url, the film crawl, the person url, the starship url, etc.).

###What I did not do
- Implement retry in case of network error. 
- The cards in the lists need design.




