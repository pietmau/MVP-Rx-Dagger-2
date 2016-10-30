**Please note**: the test comes in two product flavours: "prod" and "mock".
To run the application please select the "prod" flavour.
To tun the instrumented tests please select the "mock" flavour, it injects a mock api dependency.  


**THECNICLA CONSIDARATIONS**

**TESTS**
JUnit and Instrumented (Espresso) tests are present in the respective source folders.
Coverage is 19% of classes, 10% of lines. More tests need to be written.

**Architectural approach**
A simple implementation of the MPV pattern is applied. 
The Presenters subscribe to the Model via Observers (Rx) to receive the data.
They subscribe in onResume() and unscubscribe in onPause() to avoid leaks.
The requests to the StarWars api are cached using the Observable.cache() operator.

But we need to store the cached requests themselves so that they survive config changes, otherwise there would be no benefit in caching.
I decided to store them in the application class. 
