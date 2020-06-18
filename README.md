# Livedata

This is a repository which shows through an example how we can combine **viewmodel** and **livedata** following MVVM architecture to better structure our code.
The main motivation behind this *code snippet* or I would say a demo android app is to show how we can **observe** livedata and work with them.

The Connection of the different components of the App is as follows :

                            
MainActivity   ->  MainViewModel   ->  FakeRepository
            
N.B: **->** represents the flow of data.

In the **activity_main.xml**, we bind the data via:
```xml
<data>
        <variable
            name="viewmodel"
            type="com.example.livedata.main.MainActivityViewModel" />
</data>
```

Again we bind the viewModel in the **MainActivity.kt** :
```kotlin
  val binding:  ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
  binding.lifecycleOwner = this
  val mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
  binding.viewmodel = mainViewModel
```

Example of an observer is as follows:
```kotlin
  mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
```

Required Dependencies are:
```gradle
    //ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
```
