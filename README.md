# Android Lifecycle

The Android lifecycle is a series of states through which an Android application progresses during its execution. Understanding these states is essential for managing resources efficiently and ensuring a smooth user experience.

## Lifecycle Overview

An Android app has multiple components, with **Activity** and **Fragment** being the most common. Each of these components has a defined lifecycle managed by the Android operating system.

### Activity Lifecycle

The activity lifecycle consists of the following methods:

1. **onCreate()**
   - Called when the activity is first created.
   - Used for initialization, such as setting the layout and initializing variables.

2. **onStart()**
   - Called when the activity becomes visible to the user.

3. **onResume()**
   - Called when the activity starts interacting with the user.
   - The app is now in the foreground and the user can interact with it.

4. **onPause()**
   - Called when the system is about to resume another activity.
   - Use this method to pause operations such as animations or sensor updates.

5. **onStop()**
   - Called when the activity is no longer visible to the user.

6. **onRestart()**
   - Called when the activity is being restarted after being stopped.

7. **onDestroy()**
   - Called before the activity is destroyed.
   - Use this method to release resources and clean up tasks.
  
### Activity lifecycle

- App Launch → `onCreate`, `onStart`, `onResume`
- App Minimize → `onPause`, `onStop` | App Restore → `onRestart`, `onStrat`, `onResume`
- Open Another Activity → `onPause`, `onStop` | Back → `onRestart`, `onStart`, `onResume`
- App Orientation Change → `onPause`, `onStop`, `onDestroy`, `onCraete`, `onStart`, `onResume`
  
## Lifecycle Diagram

![Android Lifecycle Diagram](https://developer.android.com/guide/components/images/activity_lifecycle.png)

### Fragment Lifecycle

Fragments have a similar but slightly extended lifecycle compared to activities:

1. **onAttach()**
   - Called when the fragment is associated with its activity.

2. **onCreate()**
   - Called to initialize the fragment.

3. **onCreateView()**
   - Called to create and return the fragment's UI.

4. **onViewCreated()**
   - Called after the fragment's view is created.

5. **onStart()**
   - Called when the fragment becomes visible.

6. **onResume()**
   - Called when the fragment starts interacting with the user.

7. **onPause()**
   - Called when the fragment is no longer interacting with the user.

8. **onStop()**
   - Called when the fragment is no longer visible.

9. **onDestroyView()**
   - Called when the fragment's view is destroyed.

10. **onDestroy()**
    - Called when the fragment is being destroyed.

11. **onDetach()**
    - Called when the fragment is detached from its activity.

## Lifecycle Diagram

![Android Lifecycle Diagram](https://developer.android.com/static/images/guide/fragments/fragment-view-lifecycle.png)

## Best Practices

- Always release resources such as database connections, threads, or listeners in `onStop()` or `onDestroy()`.
- Save the state of the activity in `onSaveInstanceState()` to restore it later.
- Use `ViewModel` or `LiveData` to manage data efficiently and persist it across configuration changes.
- Avoid lengthy operations on the main thread. Use background threads or `AsyncTask` for such tasks.

## Additional Resources

- [Android Developer Documentation: Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
- [Android Developer Documentation: Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)

 ---
Happy coding! 🎉
