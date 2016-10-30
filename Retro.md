**Please note**: the demo comes in two product flavours: "prod" and "mock".
To run the application please select the "prod" flavour. 
To run the instrumented tests please select the "mock" flavour, it injects a mock api dependency.  


##Technical considerations

###Tests
JUnit and Instrumented (Espresso) tests are present in the respective source folders.
Coverage is 19% of classes, 10% of lines. 
More tests need to be written.

###Architectural approach
A simple implementation of the MPV pattern is applied. 
The Presenters subscribe to the Model via Observers (Rx) to receive the data.They subscribe in `onResume()` and unscubscribe in `onPause()` to avoid leaks.The requests to the StarWars api are cached using the `Observable.cache()` operator.

We need to store the cached requests themselves so that they survive config changes, otherwise there would be no benefit in caching.I decided to store them in the Application class. I am aware this approach can be discussed, various other solutions are possible: 
use a Service (started service to outlive the Activity config changes, bound to allow communication), use a retained Fragment, store 
them in the Singleton Model itself. 

Dependencies are injected using Dagger 2.

##Product considerations

###Assumptions
I assumed I could merge the two stories in one deliverable, a single demo, for convenience, and used a `BottomNavigationView`
for switching the `Fragments`. This would need to be discussed if appropriate for the case.
###To be further discussed
The first question would be: which are the key info to show in the list, because I made some assumptions 
about what to show (I do not show the film url, the film crawl, the person url, the starship url, etc.).

###Need to do next
- We really need to give the user a progress indicator while data are loading.
- We should be able to give some error message if it's the case (the presenters have a stub for it now)
- 




