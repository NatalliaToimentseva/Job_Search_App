# Job Search App

## Technology stack used in development:<br />

* language - Kotlin<br />
* Single Activity App<br />
* UI - XML <br />
* Architecture - Clean Architecture, UI layer - MVVM, LiveData<br />
* Navigation - Jetpack Navigation Component <br />
* Dependency injection - Koin<br />
* Asynchrony - Сoroutines and Kotlin Flow<br />
* Network -Retrofit2, parser - GSON<br />
* DataBase - Room<br />
* Libraries - AdapterDelegatesr<br />

## 1. Modules:<br />

* App - contains Main Activity, Application class, basic DI and screen mocks<br />
* Core - сontains:<br />
    - common utilities, resources, a common sealed class GeneralScreenViews for the AdapterDelegate;<br />
    - VacancyAdapterDelegate and VacancyViewHolder screen models common to fragments;<br />
    - an interface Navigation for implementing navigation between lists and a detail screen.<br />
* Domain - contains models for the presentation layer, Use cases and interfaces for repositories<br />
* Data - contains the implementation of the database and API; implementations of interfaces<br />
* Feature-Main - contains MainFragment, MainViewModel, and adapters<br />
* Feature-Favorites - contains FavoriteFragment, FavoriteViewModel, and adapters<br />

![app modules](https://github.com/user-attachments/assets/74f26356-5803-45d6-b4c0-dbb339c42ee2)

## 2. Navigation

Navigation is represented by MainNavigationGraph<br />

![Screenshot_2](https://github.com/user-attachments/assets/7d0ca6ea-2ef6-4f22-8250-20174380434b)

The transition from fragments of Feature-Main Feature-Favorites modules is carried out using the interface Navigation  from the core module:<br />
 ```kotlin
fun Fragment.navigate(): Navigation {
    return requireActivity() as Navigation
}
```
![Screenshot_3](https://github.com/user-attachments/assets/c54f73d5-34fb-447a-8926-957354f6e736)


